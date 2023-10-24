package com.example.conversordemoedas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class tela2_activity extends Activity {

	private EditText valorConverter;
	private TextView valorConvertido;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela2);

		valorConverter = findViewById(R.id.valorConverter);
		valorConvertido = findViewById(R.id.valorConvertido);
	}

	public void TelaConfiguracao(View v) {
		Intent telaConfiguracao = new Intent(this, tela3_activity.class);
		startActivity(telaConfiguracao);
	}

	public void IrParaHome(View v) {
		Intent telaHome = new Intent(this, tela1_activity.class);
		startActivity(telaHome);
	}

	public void converter(View v) {
		final Intent intent = getIntent();
		final String tipoDeMoedaSelecionada = intent.getStringExtra("tipoMoedaSelecionada");
		final String txtValor = valorConverter.getText().toString();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// Convertendo o valor para um número de ponto flutuante
					double valorEmDouble = Double.parseDouble(txtValor);

					Context ctx = getBaseContext();

					// Realizando a conversão
					final double conversao =
							ConversorDeMoedas.converterParaReal(ctx
									, valorEmDouble, tipoDeMoedaSelecionada, getApplicationContext());

					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							if (conversao >= 0.0) {
								String valorConvertidoStr = String.valueOf(conversao);
								valorConvertido.setText(valorConvertidoStr);
							} else {
								valorConvertido.setText("Erro na conversão");
							}
						}
					});
				} catch (NumberFormatException e) {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							valorConvertido.setText("Valor inválido");
						}
					});
				}
			}
		}).start();
	}
}
