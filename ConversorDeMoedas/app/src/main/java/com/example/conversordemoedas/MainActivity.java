package com.example.conversordemoedas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Função TelaInicio é atribuida ao botão pela metodo OnClick no xml
    public void TelaInicio(View v) {
        Intent telaInicio = new Intent(this, tela1_activity.class);
        startActivity(telaInicio);
    }
}

