package com.eii.encuentroii;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.eii.encuentroii.request.RegisterRequest;

import org.json.JSONException;
import org.json.JSONObject;

import static java.lang.Thread.sleep;

public class Registro extends AppCompatActivity {
    Button btEnviar;
    Spinner spEstado, spGenero, spEscuela;
    EditText etPassConfir, etNombre, etApellidos, etEdad, etMunicipio, etCodigo, etCorreo, etPass;
    String nombre;
    String apellidos;
    String edad;
    String genero;
    String estado ;
    String municipio;
    String codigo;
    String escuela;
    String correo;
    String pass ;
    String passConfir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        opciones();
        inicializar();
        envioDatos();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Registro.this, "Tu información es confidencial y solo se usara para generar tu perfil de usuario", Toast.LENGTH_SHORT).show();
            }
        },20);
    }


    public void opciones() {

        spEstado = (Spinner) findViewById(R.id.spEstado);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.estados, R.layout.spinner_item_config);
        spEstado.setAdapter(adapter);
        spGenero = (Spinner) findViewById(R.id.spGenero);
        ArrayAdapter<CharSequence> adapterGenero = ArrayAdapter.createFromResource(this, R.array.genero, R.layout.spinner_item_config);
        spGenero.setAdapter(adapterGenero);
        spEscuela = (Spinner) findViewById(R.id.spEscuela);
        ArrayAdapter<CharSequence> adapterEscuela = ArrayAdapter.createFromResource(this, R.array.escuelas, R.layout.spinner_item_config);
        spEscuela.setAdapter(adapterEscuela);
    }

    public void inicializar() {

        etApellidos = (EditText) findViewById(R.id.etApellidos);
        etCodigo = (EditText) findViewById(R.id.etCodigo);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etPass = (EditText) findViewById(R.id.etPass);
        etPassConfir = (EditText) findViewById(R.id.etPassConfir);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etMunicipio = (EditText) findViewById(R.id.etMunicipio);
        etEdad = (EditText) findViewById(R.id.etEdad);
        btEnviar = (Button) findViewById(R.id.btnRegistro);
    }

    public void envioDatos() {


        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nombre = etNombre.getText().toString().trim();
                apellidos = etApellidos.getText().toString().trim();
                edad = etEdad.getText().toString().trim();
                genero = spGenero.getSelectedItem().toString().trim();
                estado = spEstado.getSelectedItem().toString().trim();
                municipio = etMunicipio.getText().toString().trim();
                codigo = etCodigo.getText().toString().trim();
                escuela = spEscuela.getSelectedItem().toString().trim();
                correo = etCorreo.getText().toString().trim();
                pass = etPass.getText().toString().trim();
                passConfir = etPassConfir.getText().toString().trim();
                if(nombre.equals("")|| apellidos.equals("")||edad.equals("")||municipio.equals("")||codigo.equals("")||correo.equals("")||pass.equals("")||correo.equals("")){

                    Toast.makeText(Registro.this, "Faltan campos por llenar", Toast.LENGTH_SHORT).show();

                }else{
                    if (pass.equals(passConfir)) {

                        Response.Listener<String> responseListener = new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonResponse = new JSONObject(response);
                                    boolean success = jsonResponse.getBoolean("success");

                                    if (success) {

                                        Intent intent = new Intent(Registro.this,acceso.class);
                                        startActivity(intent);

                                    } else {
                                        Toast.makeText(Registro.this, "Este correo ya fue registrado", Toast.LENGTH_SHORT).show();
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        };


                        RegisterRequest registerRequest = new RegisterRequest(nombre, apellidos, edad, genero, estado, municipio, codigo, escuela, correo, pass, responseListener);
                        RequestQueue queue = Volley.newRequestQueue(Registro.this);
                        queue.add(registerRequest);
                    } else {
                        Toast.makeText(Registro.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }

                }
            }


        });

    }

}