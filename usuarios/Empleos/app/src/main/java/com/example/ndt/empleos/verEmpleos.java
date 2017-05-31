package com.example.ndt.empleos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class verEmpleos extends AppCompatActivity {

    @Override//metdo oncreate sirve para inicializar la parte grafica del programa al inicio
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_empleos);//se inicializa la parte grafica
    }
    //metodo que sirve para pasar a la activity verProfesionista
    public  void verProfesionista(View view){
        Intent siguiente = new Intent(verEmpleos.this,verProfesionista.class);
        startActivity(siguiente);//se inicia
    }
    //metodo que sirve para pasar a la activity verTecnicos
    public void verTecnicos(View view){
        Intent siguiente = new Intent(verEmpleos.this,verTecnico.class);
        startActivity(siguiente);//se inicia
    }
}
