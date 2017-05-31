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

public class verProfesionista extends AppCompatActivity {
TextView respuesta;//se declara una variable
    @Override//el metodo oncreate sirve para inicializar la parte grafica al inicio cuando se carga el programa
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_profesionista);//en esta parte se instancia el activity o vista que se vera
          respuesta = (TextView) findViewById(R.id.empleosSalida);//se asigna la variable al elemento grafico
        //se hace una solicitud
        RequestQueue queue = Volley.newRequestQueue(this);
        //Se crea una variable  que contiene la url
        String url = "http://usuario.890m.com/php/verProfesionistas.php";

        //se hace una solicitud en ella se pasa el tipo de metodo que se usara en este caso se uso GET,tambien se le pasa la url
        //y se crea un escuchador que recibira las respuestas del servicio web
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override//en el metodo onresponse se ejecutara si se realiza con exito la solicitud
            public void onResponse(String response) {
                respuesta.setText("resultado " + response);//se imprime resultado mas el resultado del webservice
            }
        }, new Response.ErrorListener() {
            @Override//el metodo onErrorResponse se realiza si no ocurre con exito la solicitud
            public void onErrorResponse(VolleyError error) {
                respuesta.setText("no se pudo realizar la peticion");//se muestra si no se realiza la solicitud

            }
        });
        queue.add(stringRequest);//se añaden todos los necesario a la solicitud
    }
}
