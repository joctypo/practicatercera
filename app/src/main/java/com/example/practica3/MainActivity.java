package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button botonconfiguracion;
    private EditText nombre;
    private ConstraintLayout root;
    private Button continuar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //String nombre = getIntent().getExtras().toString();
        botonconfiguracion = findViewById(R.id.botonconfiguracion);
        nombre = findViewById(R.id.nombre);
        root=findViewById(R.id.root);
        continuar=findViewById(R.id.continuar);



        botonconfiguracion.setOnClickListener(
                v -> {

                    Intent i= new Intent(this,Configuracion.class);


                    startActivity(i);

                }


        );
        pintarfondo();
        continuar.setOnClickListener(
                v -> {


                    String nombres = nombre.getText().toString();
                    Intent i=new Intent(this,CalculoNota.class);
                    i.putExtra("nombres",nombres);
                    startActivity(i);


                }
        );




    }

    private void pintarfondo() {

        SharedPreferences preferences= getSharedPreferences("color",MODE_PRIVATE);
        String colorfondo= preferences.getString("colorfondo","#FFFFFF");
        root.setBackgroundColor(Color.parseColor(colorfondo));

    }
}