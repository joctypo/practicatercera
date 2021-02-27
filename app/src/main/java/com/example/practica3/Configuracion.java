package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class Configuracion extends AppCompatActivity {

    private String color;
    private Button azulboton;
    private Button azulboton2;
    private Button azulboton3;
    private ConstraintLayout rootconfiguracion;

    //El dos es blanco y el tres es negro
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        azulboton = findViewById(R.id.azulboton);
        azulboton2 = findViewById(R.id.azulboton2);
        azulboton3 = findViewById(R.id.azulboton3);
        rootconfiguracion = findViewById(R.id.rootconfiguracion);

        azulboton.setOnClickListener(

                v -> {

                    color = "#A0F1FF";
                    lasprefencias();
                    Intent i = new Intent(this,MainActivity.class);

                    startActivity(i);
                    finish();


                }
        );

        azulboton2.setOnClickListener(

                v -> {

                    color = "#FFFFFF";
                    lasprefencias();
                    Intent i = new Intent(this,MainActivity.class);

                    startActivity(i);
                    finish();

                }
        );

        azulboton3.setOnClickListener(

                v -> {

                    color = "#000000";
                    lasprefencias();
                    Intent i = new Intent(this,MainActivity.class);

                    startActivity(i);
                    finish();

                }
        );

    }

    private void lasprefencias() {

        rootconfiguracion.setBackgroundColor(Color.parseColor(color));
        SharedPreferences preferences= getSharedPreferences("color",MODE_PRIVATE);
        preferences.edit().putString("colorfondo",color).apply();

    }


}