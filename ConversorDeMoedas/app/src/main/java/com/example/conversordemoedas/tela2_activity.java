package com.example.conversordemoedas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


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

		valorConverter = (EditText) findViewById(R.id.valorConverter);
		valorConvertido = (TextView) findViewById(R.id.valorConvertido);
	}

	/*
	As Intents (Intenção) são fora do metodo OnCreate e sempre vão receber uma View como parametro,
	Elas precisam ser publicas para serem acessadas no xml pelo OnClick
	 */
		public void TelaConfiguracao(View v) {
			Intent telaConfiguracao = new Intent(this, tela3_activity.class);
			startActivity(telaConfiguracao);
		}

		public void IrParaHome(View v) {
			Intent telaHome = new Intent(this, tela1_activity.class);
			startActivity(telaHome);
		}

		Intent intent = getIntent();
		String tipoDeMoedaSelecionada = intent.getStringExtra("tipoMoedaSelecionada");

	public void operacao(double valor, String moeda){
		double valorConvertidoDouble;
		valorConvertidoDouble = ConversorDeMoedas.converterParaReal(valor, moeda);
		String valorConvertidoStr = String.valueOf(valorConvertido);
		valorConvertido.setText(valorConvertidoStr);

	}

	public void converter(View v){
		String txtValor = valorConverter.getText().toString();
		double valorEmDouble = Double.parseDouble(txtValor);
		operacao(valorEmDouble, tipoDeMoedaSelecionada);
	}

}
	
	