package com.example.conversordemoedas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tela1_activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela1);
	}

	public void TelaConfiguracao(View v) {
		Intent telaConfiguracao = new Intent(this, tela3_activity.class);
		startActivity(telaConfiguracao);
	}

	String tipoMoedaSelecionada;

	public void idDaMoeda(View view) {
		int idDoBotao = view.getId();

		switch (idDoBotao) {
			case R.id.btnUSD:
				tipoMoedaSelecionada = "USD";
				break;
			case R.id.btnEURO:
				tipoMoedaSelecionada = "EUR";
				break;
			case R.id.btnLIBRA:
				tipoMoedaSelecionada = "GBP";
				break;
			case R.id.btnPESO:
				tipoMoedaSelecionada = "ARS";
				break;
			case R.id.btnYENE:
				tipoMoedaSelecionada = "JPY";
				break;
			case R.id.btnAUSTRALIANO:
				tipoMoedaSelecionada = "AUD";
				break;
			case R.id.btnCANADENSE:
				tipoMoedaSelecionada = "CAD";
				break;
			case R.id.btnYUAN:
				tipoMoedaSelecionada = "CNY";
				break;
			default:
				tipoMoedaSelecionada = "";
		}
	}

	public void TelaConversao(View view) {
		idDaMoeda(view);
		Intent telaConversao = new Intent(this, tela2_activity.class);
		telaConversao.putExtra("tipoMoedaSelecionada", tipoMoedaSelecionada);
		startActivity(telaConversao);
	}
}