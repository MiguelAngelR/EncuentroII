package com.eii.encuentroii;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class contacto extends AppCompatActivity {

    Toolbar toolbar;
    ImageButton imbFacebook, imbInstagram;
    ImageView ivLogo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        muestraToolbar(getResources().getString(R.string.contacto),true,true);
        instanciar();
        botones();

    }

    public void muestraToolbar(String titulo , boolean nav, boolean buscar){

        toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(nav);
        getSupportActionBar().setDisplayHomeAsUpEnabled(buscar);

    }

    public void botones(){

        imbFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.facebook.com/encuentroii/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        imbInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.instagram.com/encuentroii/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        ivLogo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.encuentroii.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

    public void instanciar(){
        imbFacebook = (ImageButton)findViewById(R.id.imbFacebook);
        imbInstagram = (ImageButton)findViewById(R.id.imbInstagram);
        ivLogo2 = (ImageView)findViewById(R.id.ivLogo2);
    }
}
