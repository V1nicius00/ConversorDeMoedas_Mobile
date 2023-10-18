package com.example.conversordemoedas;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

public class tela1_activity extends Activity {

	private TextView valorDolar;
	private TextView valorLibra;
	private TextView valorEuro;
	private	 View btnUSD;
	private View btnEURO;
	private View btnYENE;
	private View btnLIBRA;
	private View btnAUTRALIANO;
	private View btnCANADENSE;
	private View btnYUAN;
	private View btnPESO;
	private ImageView settings;
	private ImageView home;

	@SuppressLint("MissingInflatedId")
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela1);

		valorDolar = (TextView) findViewById(R.id.valorDolar);
		valorEuro = (TextView) findViewById(R.id.valorEuro);
		valorLibra = (TextView) findViewById(R.id.valorLibra);
		btnUSD = (View) findViewById(R.id.btnUSD);
		btnEURO = (View) findViewById(R.id.btnEURO);
		btnYENE = (View) findViewById(R.id.btnYENE);
		btnLIBRA = (View) findViewById(R.id.btnLIBRA);
		btnAUTRALIANO = (View) findViewById(R.id.btnAUSTRALIANO);
		btnCANADENSE = (View) findViewById(R.id.btnCANDENSE);
		btnYUAN = (View) findViewById(R.id.btnYUAN);
		btnPESO = (View) findViewById(R.id.btnPESO);
		settings = (ImageView) findViewById(R.id.settings);
		home = (ImageView) findViewById(R.id.homee);

	}
}
	
	