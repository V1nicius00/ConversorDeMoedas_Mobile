
package com.example.conversordemoedas;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.Locale;

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

				Spinner languageSpinner = findViewById(R.id.languageSpinner);
				ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				languageSpinner.setAdapter(adapter);

				languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
						// Obtenha o valor selecionado no Spinner
						String selectedLanguage = parentView.getItemAtPosition(position).toString();

						// Defina o idioma do aplicativo com base na seleção
						if ("Inglês".equals(selectedLanguage)) {
							setLocale("en"); // Chame uma função para atualizar o idioma para inglês
						} else if ("Espanhol".equals(selectedLanguage)) {
							setLocale("es"); // Chame uma função para atualizar o idioma para espanhol
						}

						// Recarregue a atividade para aplicar o novo idioma
//				recreate();
					}

					@Override
					public void onNothingSelected(AdapterView<?> parentView) {
						// Faz algo quando nenhum item é selecionado (opcional)
					}
				});

			}




			private void setLocale(String languageCode) {
				Locale locale = new Locale(languageCode);
				Locale.setDefault(locale);
				Configuration config = new Configuration();
				config.locale = locale;
				getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
			}


			public void IrParaHome(View v) {
				Intent telaHome = new Intent(this, tela1_activity.class);
				startActivity(telaHome);
			}
		}
		
