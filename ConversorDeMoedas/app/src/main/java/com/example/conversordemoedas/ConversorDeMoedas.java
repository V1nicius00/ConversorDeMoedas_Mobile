package com.example.conversordemoedas;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ConversorDeMoedas {

    private static final String API_KEY = "af2bc344c51c47f08711b38f6adb6364";

    public static double converterParaReal(double Vlr_a_ser_Convertido, String fromCurrency) {
        try {
            // Fazer uma solicitação HTTP para obter as taxas de câmbio em relação ao Real
            String apiUrl = "https://openexchangerates.org/api/latest.json?app_id=" + API_KEY;
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // Analisar a resposta JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonResponse = objectMapper.readTree(response.toString());
            JsonNode rates = jsonResponse.get("rates");

            // Obter a taxa de câmbio da moeda de origem para o Real
            double Vlr_Real = rates.get("BRL").asDouble();

            // Realizar a conversão

            return Vlr_a_ser_Convertido * Vlr_Real;
        } catch (IOException erro) {
            erro.printStackTrace();
            return -1.0; // retorna -1.0 para indicar o erro
        }
    }
}
