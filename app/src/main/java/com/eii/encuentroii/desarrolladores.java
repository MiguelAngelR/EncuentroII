package com.eii.encuentroii;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class desarrolladores extends AppCompatActivity {

    ImageButton linkedin,carbonmade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desarrolladores);
        inicializar();
        botones();
    }

    void inicializar(){

        linkedin = (ImageButton)findViewById(R.id.ibLinkedin);
        carbonmade = (ImageButton)findViewById(R.id.ibCarbonmade);

    }

    void botones(){

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/miguelriosalonso");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        carbonmade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://paperm29.carbonmade.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

}
