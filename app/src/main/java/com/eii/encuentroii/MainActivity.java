package com.eii.encuentroii;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.nsd.NsdManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.eii.encuentroii.view.ContainerActivity;
import com.eii.encuentroii.view.ContainerTallerActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageButton btnTalleres,btnConferencias,btnContacto;
    TextView Tvusuario,Tvedad,Tvgenero,Tvestado,Tvmunicipio,Tvescuela,Tvcorreo,Tvcodigo;
    String idR;
    String usuarioR;
    String edadR;
    String generoR;
    String estadoR;
    String municipioR;
    String escuelaR;
    String correoR;
    String codigoR;
    private final static String PREFERENCES_DATOS_USUARIO = "datosUsuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recuperarDatos();
        instanciar();
        //recibir_datos();
        botones();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
    }



    @Override
    public void onBackPressed() {

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
             Intent intent = new Intent(MainActivity.this,desarrolladores.class);
             startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_conferencias) {
            Intent intent = new Intent(MainActivity.this,ContainerActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_anterior) {

            Intent intent = new Intent(MainActivity.this,GaleriaActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_talleres) {

            Intent intent = new Intent(MainActivity.this,ContainerTallerActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_contacto) {
            Intent intent = new Intent(MainActivity.this, contacto.class);
            startActivity(intent);
        } else if (id == R.id.nav_perfil) {
            Intent datos = new Intent(MainActivity.this,perfil.class);
            datos.putExtra("usuario", usuarioR);
            datos.putExtra("edad", edadR);
            datos.putExtra("genero", generoR);
            datos.putExtra("estado", estadoR);
            datos.putExtra("municipio", municipioR);
            datos.putExtra("escuela", escuelaR);
            datos.putExtra("correo", correoR);
            datos.putExtra("codigo", codigoR);
            startActivity(datos);
        } else if(id  == R.id.nav_registrate){
            Intent registrate = new Intent(MainActivity.this, Registro.class);
            startActivity(registrate);
        } else if(id  == R.id.nav_login){
            Intent login = new Intent(MainActivity.this, Login.class);
            startActivity(login);
        }else if(id == R.id.nav_logout){

            SharedPreferences preferences = getSharedPreferences(PREFERENCES_DATOS_USUARIO,MODE_PRIVATE);
            preferences.edit().clear().apply();
            Intent login = new Intent(MainActivity.this, Login.class);
            startActivity(login);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void botones(){

        btnConferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent conferencias = new Intent(MainActivity.this,ContainerActivity.class);
                startActivity(conferencias);
            }
        });

        btnTalleres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent talleres = new Intent(MainActivity.this,ContainerTallerActivity.class);
                startActivity(talleres);

            }
        });

        btnContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent contacto = new Intent(MainActivity.this,contacto.class);
                startActivity(contacto);
            }
        });



    }

    public void instanciar(){
        btnConferencias = (ImageButton)findViewById(R.id.btConferencias);
        btnTalleres = (ImageButton)findViewById(R.id.btTalleres);
        btnContacto = (ImageButton)findViewById(R.id.btContacto);
        Tvusuario = (TextView)findViewById(R.id.tvUsuario);
        Tvedad = (TextView)findViewById(R.id.tvEdad);
        Tvgenero = (TextView)findViewById(R.id.tvGenero);
        Tvestado = (TextView)findViewById(R.id.tvEstado);
        Tvmunicipio = (TextView)findViewById(R.id.tvMunicipio);
        Tvescuela = (TextView)findViewById(R.id.tvEscuela);
        Tvcorreo = (TextView)findViewById(R.id.tvEscuela);
        Tvcodigo = (TextView)findViewById(R.id.tvCodigo);



    }

     public void recibir_datos(){

        /*
        Intent recibir = getIntent();
        if(recibir.getExtras() != null) {
            usuarioR = recibir.getExtras().getString("usuario");
            edadR = recibir.getExtras().getString("edad");
            generoR = recibir.getExtras().getString("genero");
            estadoR = recibir.getExtras().getString("estado");
            municipioR = recibir.getExtras().getString("municipio");
            escuelaR = recibir.getExtras().getString("escuela");
            correoR = recibir.getExtras().getString("correo");
            codigoR = recibir.getExtras().getString("codigo");

            Tvusuario.setText(usuarioR);
            Tvedad.setText(edadR);
            Tvgenero.setText(generoR);
            Tvestado.setText(estadoR);
            Tvmunicipio.setText(municipioR);
            Tvescuela.setText(escuelaR);
            Tvcorreo.setText(correoR);
            Tvcodigo.setText(codigoR);
            tvNoticiasTitulo.setText("Bienvenido "+usuarioR+" ¿Ya revisaste lo nuevo en el evento?");


            Toast.makeText(this, "Bienvenido " + usuarioR, Toast.LENGTH_LONG).show();
        }else {
            tvNoticiasTitulo.setText("Bienvenido mantente al día con del evento, mira estas notificaciones");
            Toast.makeText(this, "Bienvenido , no olvides registrarte para poder generar tu codigo QR", Toast.LENGTH_LONG).show();
        }
        */
    }

    public void recuperarDatos() {

        SharedPreferences preferences = getSharedPreferences(PREFERENCES_DATOS_USUARIO, MODE_PRIVATE);
        idR = preferences.getString("Id", "invitado");
        usuarioR = preferences.getString("Usuario", "invitado");
        edadR = preferences.getString("Edad", "");
        generoR = preferences.getString("Genero", "");
        estadoR = preferences.getString("Estado", "");
        municipioR = preferences.getString("Municipio", "");
        escuelaR = preferences.getString("Escuela", "");
        correoR = preferences.getString("Correo", "Invitado");
        codigoR = preferences.getString("Codigo", "");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences preferences = getSharedPreferences(PREFERENCES_DATOS_USUARIO,MODE_PRIVATE);
        preferences.edit().clear().apply();
    }
}
