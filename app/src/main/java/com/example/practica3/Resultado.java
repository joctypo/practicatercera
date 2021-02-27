package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private Button otravez;
    private TextView hola,resultado;
    private ConstraintLayout rootresultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        String nombres = getIntent().getExtras().getString("nombres");
        String nota = getIntent().getExtras().getString("nota");

        hola = findViewById(R.id.hola);
        resultado = findViewById(R.id.resultado);
        otravez= findViewById(R.id.otravez);
        rootresultados = findViewById(R.id.rootresultado);
        pintarfondo();
        hola.setText("Hola  "+nombres);
        resultado.setText(""+nota);

        otravez.setOnClickListener(
                v -> {
                    Intent i = new Intent(this,MainActivity.class);


                    startActivity(i);
                    finish();



                }
        );





    }

    private void pintarfondo() {

        SharedPreferences preferences= getSharedPreferences("color",MODE_PRIVATE);
        String colorfondo= preferences.getString("colorfondo","#FFFFFF");
        rootresultados.setBackgroundColor(Color.parseColor(colorfondo));

    }
}