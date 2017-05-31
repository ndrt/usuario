package com.example.ndt.empleos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Empleos extends AppCompatActivity {

    @Override//metdo oncreate sirve para inicializar la parte grafica del programa al inicio
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleos);//se inicializa la parte grafica
    }
    //metodo que permite pasar a la activity registrar
public void registraEmpleo(View view){
    Intent siguiente = new Intent(Empleos.this,registrar.class);
    startActivity(siguiente);//se inicia
}
    //metodo que permite pasar ala activiy verEmpleos
public void verEmpleos(View view){
    Intent siguiente = new Intent(Empleos.this,verEmpleos.class);
    startActivity(siguiente);//se inicia
}

}
