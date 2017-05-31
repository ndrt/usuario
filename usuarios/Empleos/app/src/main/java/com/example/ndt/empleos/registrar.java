package com.example.ndt.empleos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class registrar extends AppCompatActivity {

    @Override//metdo oncreate sirve para inicializar la parte grafica del programa al inicio
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);//se inicializa la parte grafica
    }
    //metodo que permite pasar a la activity registrarProfesionista
    public void ingreProfesionista(View view){
        Intent siguiente = new Intent(registrar.this, registrarProfesionista.class);
        startActivity(siguiente);//se inicia
    }
    //metodo que permite pasar a la activity registra tecnico
    public void ingreTecnico(View view){
        Intent siguiente = new Intent(registrar.this, registraTecnico.class);
        startActivity(siguiente);//se inicia
    }
    public void ingresaEstudiante(View view){
        Intent siguiente = new Intent(registrar.this, registraEstudiante.class);
        startActivity(siguiente);//se inicia
    }
}
