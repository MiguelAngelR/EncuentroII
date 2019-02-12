package com.eii.encuentroii;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class splashscreen extends AppCompatActivity {

    LinearLayout lnScreen;
    private final static String STRING_PREFERENCES = "loginActivity";
    private final static String PREFERENCES_STBUTTON = "estadoBotonSesion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        lnScreen = findViewById(R.id.lnSplashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(obtenerEstadoButton()){
                    Intent intent = new Intent(splashscreen.this, MainActivity.class);
                    startActivity(intent);

                }else{
                    Intent intent = new Intent(splashscreen.this, Login.class);
                    startActivity(intent);
                }

            }
        },2000);

        regresar();
    }

    public void regresar()
    {
        lnScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(splashscreen.this,Login.class);
                startActivity(regresar);
            }
        });
    }

    public boolean obtenerEstadoButton(){

        SharedPreferences preferences = getSharedPreferences(STRING_PREFERENCES,MODE_PRIVATE);
        return preferences.getBoolean(PREFERENCES_STBUTTON,false);
    }

}
