package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CalculoNota extends AppCompatActivity {

    private EditText parcial1;
    private EditText parcial2;
    private EditText quices;
    private EditText parcial10;
    private EditText parcial20;
    private ConstraintLayout rootcalculo;
    private Button calcular;
    Float notas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_nota);

        String nombres = getIntent().getExtras().getString("nombres");

        parcial1 = findViewById(R.id.parcial1);
        parcial2 = findViewById(R.id.parcial2);
        quices = findViewById(R.id.quices);
        parcial10 = findViewById(R.id.parcial10);
        parcial20 = findViewById(R.id.parcial20);
        calcular = findViewById(R.id.calcular);
        rootcalculo = findViewById(R.id.rootcalculo);
        pintarfondo();
        calcular.setOnClickListener(

                v -> {
                    encontrarpromedio();
                    String nota= ""+ notas;
                    Intent i= new Intent(this,Resultado.class);

                    i.putExtra("nombres",nombres);
                    i.putExtra("nota",nota);

                    startActivity(i);
                    finish();
                }
        );


    }

    private void encontrarpromedio() {
        String p1= parcial1.getText().toString();
        String p2= parcial2.getText().toString();
        String q = quices.getText().toString();
        String p10=parcial10.getText().toString();
        String p20=parcial20.getText().toString();

        Float pa1 = Float.parseFloat(p1);
        Float pa2 = Float.parseFloat(p2);
        Float q1 = Float.parseFloat(q);
        Float pa10 = Float.parseFloat(p10);
        Float pa20 = Float.parseFloat(p20);

        notas= ((pa1+pa2+q1+pa10+pa20)/5);

       // Float paa2 = Float.parseFloat(parcial1.getText().toString());



    }

    private void pintarfondo() {

        SharedPreferences preferences= getSharedPreferences("color",MODE_PRIVATE);
        String colorfondo= preferences.getString("colorfondo","#FFFFFF");
        rootcalculo.setBackgroundColor(Color.parseColor(colorfondo));

    }
}