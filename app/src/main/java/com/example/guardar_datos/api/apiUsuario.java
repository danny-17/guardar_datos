package com.example.guardar_datos.api;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.guardar_datos.modelo.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class apiUsuario  {

    private boolean bandera=false;
    private Context contexto;
    //final String URL = "https://tecnistoreaapi.rj.r.appspot.com/usuario";

    /*public apiUsuario(Context contexto) {
        this.contexto = contexto;
    }

    public boolean postDatosVolley2(ArrayList<Usuario> usuario){
        RequestQueue queue = Volley.newRequestQueue(contexto);
        StringRequest sr = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                bandera=true;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                bandera=false;
            }
        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                for (int i = 0; i < usuario.size(); i++) {
                    //params.put("idUsuario", "0");
                    params.put("usuario", usuario.get(i).getNombreUsuario());
                    params.put("clave", usuario.get(i).getClaveUsuario());
                    //params.put("idUsuario", String.valueOf(9));
                    params.put("tipoUsuario", "cliente");
                    System.out.println("tipo = " + "cliente");
                    //params.put("idCliente", String.valueOf(usuario.get(i).getIdCliente()));
                }
                return params;
            }
        };
        queue.add(sr);
        return bandera;
    }*/
}
