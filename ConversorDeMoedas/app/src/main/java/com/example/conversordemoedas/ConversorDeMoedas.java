package com.example.conversordemoedas;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorDeMoedas {
    private static final String API_KEY = "af2bc344c51c47f08711b38f6adb6364";
    private static final String TAG = "ConversorDeMoedas";


    private static boolean checkInternetConenction(final Context ctx) {
        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
                //=
                //(ConnectivityManager)getSystemService(  ctx
        // .CONNECTIVITY_SERVICE);

        // Check for network connections
        if ( connec.getNetworkInfo(0).getState() ==
                android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED ) {
//            Toast.makeText(ctx, " Connected ",
//                    Toast.LENGTH_LONG).show();
            Log.d(TAG, "Conectado!");
            return true;
        }else if (
                connec.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() ==
                                android.net.NetworkInfo.State.DISCONNECTED  ) {
//            Toast.makeText(ctx, " Not Connected ", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Não conectado!");
            return false;
        }
        return false;
    }

    public static double converterParaReal(final Context ctx,

                                           final double ValorEmReal, final String MoedaConversao, final Context context) {
        try {
            Log.d(TAG, "Iniciando a função converterParaReal()");

            if (checkInternetConenction(ctx)) {
                // Verifique se a permissão INTERNET foi concedida
//            if (context.checkSelfPermission(android.Manifest.permission.INTERNET) != android.content.pm.PackageManager.PERMISSION_GRANTED) {
//                Log.e(TAG, "Permissão INTERNET não concedida. Você precisa conceder permissão para converter.");
//                return -1.0;
//            }

                // Crie uma nova Thread para a solicitação de rede
                Thread networkThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
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
                            double valorMoeda = rates.get(MoedaConversao).asDouble();

                            // Realizar a conversão
                            double resultado = ValorEmReal * valorMoeda;

                            Log.d(TAG, "Valor de conversão: " + resultado);
                        } catch (IOException e) {
                            Log.e(TAG,
                                    "Erro na solicitação de rede: ", e);
                        }
                    }
                });

                networkThread.start();
                networkThread.join();  // Aguarde até que a Thread da rede termine
            }


            return -1.0; // Você precisa retornar um valor adequado aqui
        } catch (Exception e) {
            Log.e(TAG, "Erro na função converterParaReal(): " + e.getMessage());
            return -1.0; // Retorna -1.0 para indicar o erro
        } finally {
            Log.d(TAG, "Saindo da função converterParaReal()");
        }
    }
}
