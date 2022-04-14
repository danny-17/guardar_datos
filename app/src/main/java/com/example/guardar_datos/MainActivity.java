package com.example.guardar_datos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.guardar_datos.api.apiUsuario;
import com.example.guardar_datos.modelo.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button btnGuardar;
    private EditText txt_usu, txt_contra, txt_confirma_contra;
    RequestQueue requestQueue;
    private static  final String URL = "https://tecnistoreaapi.rj.r.appspot.com/usuario/create";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt_usu=findViewById(R.id.txt_usuarioRregistro);
        txt_contra=findViewById(R.id.txt_contraseñaRegistro);
        txt_confirma_contra=findViewById(R.id.txt_confirmarRegistro);
        btnGuardar=findViewById(R.id.btn_siguiente_datos_usuario);




        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int id= view.getId();
                //if(id==R.id.btn_siguiente_datos_usuario){
                    String nom_usua = txt_usu.getText().toString().trim();
                    String cla_usua = txt_contra.getText().toString().trim();
                    createUser(nom_usua, cla_usua);

                }
            //}
        });

        /*btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt_usu.getText().toString().isEmpty()&&txt_contra.getText().toString().isEmpty()&&txt_confirma_contra.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Llene todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    ArrayList<Usuario> datosUsuario = new ArrayList<>();
                    Usuario miusuario = new Usuario();

                    miusuario.setNombreUsuario(txt_usu.getText().toString());
                    miusuario.setClaveUsuario(txt_contra.getText().toString());
                    datosUsuario.add(miusuario);

                    apiUsuario serviUsuario = new apiUsuario(MainActivity.this);

                    boolean bandera = serviUsuario.postDatosVolley2(datosUsuario);
                    if(bandera!=false){
                        Toast.makeText(MainActivity.this, "Usuario Creado", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "El usuario no se pudo registrar", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });*/


    }

    private void createUser(final String nom_usua, final String cla_usua){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, "Usuario Guardado", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, "Error al Guardar los Datos", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("usuario", nom_usua);
                System.out.println("usuario"+ nom_usua);
                params.put("clave", cla_usua);
                System.out.println("clave"+ cla_usua);
                params.put("tipoUsuario", "cliente");
                System.out.println("cliente"+"cliente");
                return params;
            }
        };
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}