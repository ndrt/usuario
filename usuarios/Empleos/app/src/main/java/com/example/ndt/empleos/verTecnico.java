package com.example.ndt.empleos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class verTecnico extends AppCompatActivity {
    TextView respuesta;//se ddeclara variable tipo textView
    @Override//metdo oncreate sirve para inicializar la parte grafica del programa al inicio
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_tecnico);//se inicializa la parte grafica
        respuesta = (TextView) findViewById(R.id.empleosTecnicoSalida);//se asigna la variable a la parte grafica correspondiente
        //se realiza la solicitud
        RequestQueue queue = Volley.newRequestQueue(this);
        //se crea una variable llamada url que contendra la direccion de la pagina en la cual se hara la peticion o solicitus
        String url = "http://usuario.890m.com/php/verTecnicos.php";
        //se realiza la solicitud y se le pasa el metodo POST por el cual se hace el envio de la informacion
        //tambien se le añade la url y se crea un escuchador el cual recibira la respuesta del webservice
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                respuesta.setText("resultado " + response);//se lee la respuesta del webservice
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                respuesta.setText("no se pudo realizar la peticion");

            }
        });
        //imprimo que no se realizo la peticion si es que hay algun error
        queue.add(stringRequest);
    }
}
