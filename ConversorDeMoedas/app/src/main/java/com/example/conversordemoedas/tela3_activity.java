package com.example.conversordemoedas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class tela3_activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela3);
	}

		public void IrParaHome(View v) {
			Intent telaHome = new Intent(this, tela1_activity.class);
			startActivity(telaHome);
		}
}
	
	