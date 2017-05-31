package com.example.ndt.empleos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
EditText t;//se crea una variable tipo editText
EditText cla;//se crea una variable tipo editText
TextView respuesta;//se crea una variable tipo textView

    @Override//metdo oncreate sirve para inicializar la parte grafica del programa al inicio
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//se inicializa la parte grafica
        t = (EditText) findViewById(R.id.nombre);//se asigna la variable a la parte grafica correspondiente
        cla = (EditText) findViewById(R.id.clave);//se asigna la variable a la parte grafica correspondiente
        respuesta = (TextView) findViewById(R.id.respuesta);//se asigna la variable a la parte grafica correspondiente
    }


    //se crea un metodo llamado registrar en el que se hara el registro
    public void registrar(View view) {
        //se realiza una solicitud
        RequestQueue queue = Volley.newRequestQueue(this);
        //se crea una variable llamada url que contendra la direccion de la pagina en la cual se hara la peticion o solicitus
        String url = "http://usuario.890m.com/php/registrar.php";
        //se realiza la solicitud y se le pasa el metodo POST por el cual se hace el envio de la informacion
        //tambien se le añade la url y se crea un escuchador el cual recibira la respuesta del webservice
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override//metodo onresponse el cual sucede si se ejecuta con exito la peticion
            public void onResponse(String response) {
              respuesta.setText("resultado " + response);//la respuesta la muestra en un testview
            }
        }, new Response.ErrorListener() {
            @Override//metodo onErrorResponse ocurre si se produce un error
            public void onErrorResponse(VolleyError error) {
            respuesta.setText("no se pudo realizar la peticion");//muestro el error

            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() {//se hace un map de los elementos a enviar
                Map<String, String> parametros = new HashMap<>();
                parametros.put("nombre", t.getText().toString());
                parametros.put("clave", cla.getText().toString());
                return parametros;
            }
        };
        queue.add(stringRequest);//se añade a la solicitud
    }

    public void login(View view) {//metodo login el cual hara el logeo del usuario junto al webervice
        //se realiza una solicitud
        RequestQueue queue = Volley.newRequestQueue(this);
        //se crea una variable llamada url que contendra la direccion de la pagina en la cual se hara la peticion o solicitus
        String url = "http://usuario.890m.com/php/loguear.php";
        //se realiza la solicitud y se le pasa el metodo POST por el cual se hace el envio de la informacion
        //tambien se le añade la url y se crea un escuchador el cual recibira la respuesta del webservice
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override//metodo onresponse el cual sucede si se ejecuta con exito la peticion
            public void onResponse(String response) {
                if (response.trim().equals("ok")) {//si el webservice devuelde un ok ejecuta la siguiente opcion
                   Intent siguiente = new Intent(MainActivity.this, Empleos.class);//creo un nuevo inten el cual sirve para lanzar la siguiente activty
                    startActivity(siguiente);//lo inicio
                } else {
                    respuesta.setText("incorrecto");//si no escribo incorrecto
                }
            }
        }, new Response.ErrorListener() {
            @Override//metodo onErrorResponse ocurre si se produce un error
            public void onErrorResponse(VolleyError error) {

            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() {//se hace un map de los elementos a enviar
                Map<String, String> parametros = new HashMap<>();
                parametros.put("nombre", t.getText().toString());
                parametros.put("clave", cla.getText().toString());
                return parametros;
            }
        };
        queue.add(stringRequest);//se añade a la solicitud
    }
}
