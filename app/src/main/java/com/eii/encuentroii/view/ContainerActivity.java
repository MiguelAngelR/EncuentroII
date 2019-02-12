package com.eii.encuentroii.view;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eii.encuentroii.MainActivity;
import com.eii.encuentroii.R;
import com.eii.encuentroii.view.fragment.ConferenciaPrimerFragment;
import com.eii.encuentroii.view.fragment.ConferenciaSegundoFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


public class ContainerActivity extends AppCompatActivity {
    BottomBar bottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        inicializacion();
    }



    public void inicializacion(){
        bottomBar = (BottomBar)findViewById(R.id.bottomBarUno);
        bottomBar.setDefaultTab(R.id.primerDiaTab);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch(tabId){
                    case R.id.primerDiaTab:
                        ConferenciaPrimerFragment conferenciaPrimerFragment = new ConferenciaPrimerFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, conferenciaPrimerFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                    case R.id.segundoDiaTab:

                        ConferenciaSegundoFragment conferenciaSegundoFragment = new ConferenciaSegundoFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, conferenciaSegundoFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(ContainerActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
