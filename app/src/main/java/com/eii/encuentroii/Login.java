package com.eii.encuentroii;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.eii.encuentroii.request.LoginRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    //Agregar un boton de logout
    Button btnEntrar,btRegistro;
    EditText edPassLogin,edCorreoLogin;
    RadioButton rbRecordar,rbMostrar;
    CheckBox cbMostrar;
    private boolean isActivateRadioButton;
    private final static String STRING_PREFERENCES = "loginActivity";
    private final static String PREFERENCES_STBUTTON = "estadoBotonSesion";
    private final static String PREFERENCES_DATOS_USUARIO = "datosUsuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        instanciar();
        accesoUsuario();
        registro();
        botones();

    }


    public void guardarEstadoButton(){

        SharedPreferences preferences = getSharedPreferences(STRING_PREFERENCES,MODE_PRIVATE);
        preferences.edit().putBoolean(PREFERENCES_STBUTTON,rbRecordar.isChecked()).apply();
    }

    public void accesoUsuario(){


       btnEntrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               String correoLogin = edCorreoLogin.getText().toString();
               String passLogin = edPassLogin.getText().toString();

               Response.Listener<String> responseListener = new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {
                       try {
                           JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                String id = jsonResponse.getString("id");
                                String usuario = jsonResponse.getString("usuario");
                                String edad = jsonResponse.getString("edad");
                                String genero = jsonResponse.getString("genero");
                                String estado = jsonResponse.getString("estado");
                                String municipio = jsonResponse.getString("municipio");
                                String escuela = jsonResponse.getString("escuela");
                                String correo = jsonResponse.getString("correo");
                                String codigo = jsonResponse.getString("codigo");


                                Intent datos = new Intent(Login.this,MainActivity.class);
                               /* datos.putExtra("id",id);
                                datos.putExtra("usuario", usuario);
                                datos.putExtra("edad", edad);
                                datos.putExtra("genero", genero);
                                datos.putExtra("estado", estado);
                                datos.putExtra("municipio", municipio);
                                datos.putExtra("escuela", escuela);
                                datos.putExtra("correo", correo);
                                datos.putExtra("codigo", codigo); */
                                guardarDatosUsuario(id,usuario,edad,genero,estado,municipio,escuela,correo,codigo);
                                guardarEstadoButton();
                                startActivity(datos);

                            }else{
                                Toast.makeText(Login.this, "Usuario/Contraseña incorrectos ", Toast.LENGTH_SHORT).show();
                            }

                       } catch (JSONException e) {
                           e.printStackTrace();
                       }

                   }
               };

               LoginRequest loginRequest;
               loginRequest = new LoginRequest(correoLogin ,passLogin,responseListener);
               RequestQueue queue = Volley.newRequestQueue(Login.this);
               queue.add(loginRequest);

           }
       });

    }

    public void registro(){

        btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro = new Intent(Login.this,Registro.class);
                startActivity(registro);
            }
        });


    }

    public void instanciar(){
        rbRecordar = (RadioButton) findViewById(R.id.rbRecordar);
        btnEntrar = (Button)findViewById(R.id.btnEntrar);
        edPassLogin = (EditText) findViewById(R.id.etPassLogin);
        edCorreoLogin = (EditText) findViewById(R.id.etUsuarioLogin);
        btRegistro = (Button)findViewById(R.id.btRegistrate);
        cbMostrar = (CheckBox) findViewById(R.id.cbMostrar);

    }

    public void botones(){
        isActivateRadioButton = rbRecordar.isChecked(); //valor inicial del radiobutton

        rbRecordar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isActivateRadioButton){
                    rbRecordar.setChecked(false);
                }

                isActivateRadioButton = rbRecordar.isChecked();

            }
        });

        cbMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edPassLogin.setInputType(InputType.TYPE_CLASS_TEXT);
            }
        });



    }

    public void guardarDatosUsuario(String id, String usuario,
                                    String edad, String genero, String estado,
                                    String municipio, String escuela, String correo, String codigo){


        SharedPreferences datosUsuario = getSharedPreferences(PREFERENCES_DATOS_USUARIO,MODE_PRIVATE);
        SharedPreferences.Editor editor = datosUsuario.edit();
        editor.putString("Id",id);
        editor.putString("Usuario",usuario);
        editor.putString("Edad",edad);
        editor.putString("Genero",genero);
        editor.putString("Estado",estado);
        editor.putString("Municipio",municipio);
        editor.putString("Escuela",escuela);
        editor.putString("Correo",correo);
        editor.putString("Codigo",codigo);
        editor.commit();
    }

    @Override
    public void onBackPressed() {

    }

}
