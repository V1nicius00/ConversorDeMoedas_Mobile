package com.example.conversordemoedas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class tela2_activity extends Activity {

	 EditText valorConverter;
	 TextView valorConvertido;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela2);

		valorConverter = (EditText) findViewById(R.id.valorConverter);
		valorConvertido = (TextView) findViewById(R.id.valorConvertido);
	}

		public void TelaConfiguracao(View v) {
			Intent telaConfiguracao = new Intent(this, tela3_activity.class);
			startActivity(telaConfiguracao);
		}

		public void IrParaHome(View v) {
			Intent telaHome = new Intent(this, tela1_activity.class);
			startActivity(telaHome);
		}


	public void converter(View v){
		Intent intent = getIntent();
		String tipoDeMoedaSelecionada = intent.getStringExtra("tipoMoedaSelecionada");
		//TENHO A MOEDA A SER CONVERTIDA

		String txtValor = valorConverter.getText().toString();
		double valorEmDouble = Double.parseDouble(txtValor);
		//TENHO O VALOR

		double conversao = ConversorDeMoedas.converterParaReal(valorEmDouble, tipoDeMoedaSelecionada);
		String valorConvertidoStr = String.valueOf(conversao);
		//REALIZO A CONVERSÃO

		valorConvertido.setText(valorConvertidoStr);
		//INSIRO O VALOR CONVERTIDO NO CAMPO
	}

	public void teste(View v){
		Intent intent = getIntent();
		String tipoDeMoedaSelecionada = intent.getStringExtra("tipoMoedaSelecionada");
		valorConvertido.setText (tipoDeMoedaSelecionada);
	}
}
	
	