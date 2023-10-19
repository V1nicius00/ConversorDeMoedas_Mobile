package com.example.conversordemoedas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_start = findViewById<View>(R.id.btn_start) as View

        btn_start.setOnClickListener{

            TelaInicio()
        }

    }

    private fun TelaInicio(){

        val telaInicio = Intent(this, tela1_activity:: class.java)
        startActivity(telaInicio)
    }
}