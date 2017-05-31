package com.example.ndt.empleos;

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

public class registrarProfesionista extends AppCompatActivity {
EditText mensaje,telefono,correo,direccion;//instancio variables tipo editText
TextView res;//instancio varibles tipo TextView

    @Override//metdo oncreate sirve para inicializar la parte grafica del programa al inicio
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_profesionista);//se inicializa la parte grafica
        mensaje = (EditText) findViewById(R.id.mensaje);//se asigna la variable a la parte grafica correspondiente
        telefono = (EditText) findViewById(R.id.telefono);//se asigna la variable a la parte grafica correspondiente
        correo = (EditText) findViewById(R.id.correo);//se asigna la variable a la parte grafica correspondiente
        direccion = (EditText) findViewById(R.id.direccion);//se asigna la variable a la parte grafica correspondiente
        res = (TextView) findViewById(R.id.label_respuesta);//se asigna la variable a la parte grafica correspondiente
    }
    //se crea un metodo el cual registrara a los profesionistas
    public void registraProfesionista(View view){
        //se realiza una solicitud
        RequestQueue queue = Volley.newRequestQueue(this);
        //se crea una variable llamada url que contendra la direccion de la pagina en la cual se hara la peticion o solicitus
        String url = "http://usuario.890m.com/php/registrarProfesionista.php";
        //se realiza la solicitud y se le pasa el metodo POST por el cual se hace el envio de la informacion
        //tambien se le añade la url y se crea un escuchador el cual recibira la respuesta del webservice
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override//metodo onresponse el cual sucede si se ejecuta con exito la peticion
            public void onResponse(String response) {
                res.setText("resultado " + response);//escribo la respuesta que manda el webservice
            }
        }, new Response.ErrorListener() {
            @Override//metodo onErrorResponse ocurre si se produce un error
            public void onErrorResponse(VolleyError error) {
                res.setText("no se pudo realizar la peticion");//muestro el error

            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() {//se hace un map de los elementos a enviar
                Map<String, String> parametros = new HashMap<>();
                parametros.put("mensaje", mensaje.getText().toString());
                parametros.put("telefono", telefono.getText().toString());
                parametros.put("correo", correo.getText().toString());
                parametros.put("direccion", direccion.getText().toString());
                return parametros;
            }
        };
        queue.add(stringRequest);//se añade a la solicitud
    }
}
