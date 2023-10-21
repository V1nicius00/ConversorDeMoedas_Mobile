package com.example.conversordemoedas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

public class tela2_activity extends Activity {

	private View _bg__tela2_ek2;
	private TextView nome_da_moeda;
	private ImageView line_4;
	private TextView digite_o_valor_que_deseja_converter_;
	private ImageView arrow_3;
	private ImageView arrow_3_ek1;
	private TextView valor_convertido_;
	private ImageView home;
	private ImageView settings;
	private View rectangle_32;
	private View rectangle_33;
	private TextView r_20_000_00;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela2);

		
		_bg__tela2_ek2 = (View) findViewById(R.id._bg__tela2_ek2);
		nome_da_moeda = (TextView) findViewById(R.id.nome_da_moeda);
		digite_o_valor_que_deseja_converter_ = (TextView) findViewById(R.id.digite_o_valor_que_deseja_converter_);
		arrow_3 = (ImageView) findViewById(R.id.arrow_3);
		arrow_3_ek1 = (ImageView) findViewById(R.id.arrow_3_ek1);
		valor_convertido_ = (TextView) findViewById(R.id.valor_convertido_);
		home = (ImageView) findViewById(R.id.homee);
		settings = (ImageView) findViewById(R.id.settings);
		rectangle_32 = (View) findViewById(R.id.rectangle_32);
		rectangle_33 = (View) findViewById(R.id.rectangle_33);
		r_20_000_00 = (TextView) findViewById(R.id.r_20_000_00);

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
}
	
	