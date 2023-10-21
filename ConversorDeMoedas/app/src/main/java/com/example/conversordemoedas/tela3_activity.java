package com.example.conversordemoedas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

public class tela3_activity extends Activity {


	private View _bg__tela3_ek2;
	private TextView configura__es;
	private ImageView line_4;
	private ImageView home;
	private ImageView settings;
	private TextView idioma;
	private View rectangle_30;
	private TextView tema;
	private View rectangle_31;
	private View rectangle_21;
	private View ellipse_1;
	private TextView portugu_s___br;
	private TextView escuro;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela3);

		
		_bg__tela3_ek2 = (View) findViewById(R.id._bg__tela3_ek2);
		configura__es = (TextView) findViewById(R.id.configura__es);
		home = (ImageView) findViewById(R.id.homee);
		settings = (ImageView) findViewById(R.id.settings);
		idioma = (TextView) findViewById(R.id.idioma);
		rectangle_30 = (View) findViewById(R.id.rectangle_30);
		tema = (TextView) findViewById(R.id.tema);
		rectangle_31 = (View) findViewById(R.id.rectangle_31);
		portugu_s___br = (TextView) findViewById(R.id.portugu_s___br);
		escuro = (TextView) findViewById(R.id.escuro);

	}

		public void IrParaHome(View v) {
			Intent telaHome = new Intent(this, tela1_activity.class);
			startActivity(telaHome);
		}
}
	
	