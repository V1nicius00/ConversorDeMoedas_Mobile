package com.example.conversordemoedas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatDelegate;

public class tela3_activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Defina o tema com base nas preferências do usuário ou no estado do Switch
		if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
			setTheme(R.style.Theme_Dark);
		} else {
			setTheme(R.style.Theme_Light);
		}

		setContentView(R.layout.tela3);

		Switch themeSwitch = findViewById(R.id.SwitchTema);

		// Defina o estado do Switch com base no tema atual
		themeSwitch.setChecked(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES);

		themeSwitch.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged( CompoundButton buttonView, boolean isChecked) {
				// Alternar o modo noturno com base no estado do Switch
				AppCompatDelegate.setDefaultNightMode(isChecked
						? AppCompatDelegate.MODE_NIGHT_YES
						: AppCompatDelegate.MODE_NIGHT_NO);

				recreate(); // Recarregar a atividade para aplicar o novo tema
			}
		});
	}

	public void IrParaHome(View v) {
		Intent telaHome = new Intent(this, tela1_activity.class);
		startActivity(telaHome);
	}
}
