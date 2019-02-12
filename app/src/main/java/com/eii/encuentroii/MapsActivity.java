package com.eii.encuentroii;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;



        LatLng AuditorioDos = new LatLng(19.328633, -99.181128);
        LatLng AuditorioUno = new LatLng(19.331365, -99.184067);
        LatLng todos = new LatLng(19.327235, -99.181963);
        LatLng copilco = new LatLng(  19.335836, -99.177042);
        LatLng muni = new LatLng(19.324623, -99.173891);
        LatLng cele = new LatLng(19.331160, -99.183462);
        LatLng anexo = new LatLng(19.325967, -99.182019);


        mMap.addMarker(new MarkerOptions()
                .position(AuditorioUno)
                .title("Auditorio Javier Barros Sierra")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.jbs))
        );



        mMap.addMarker(new MarkerOptions()
                .position(AuditorioDos)
                .title("Auditorio Raul J. Marsal")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.arj   ))
        );

        mMap.addMarker(new MarkerOptions()
                .position(todos)
                .title("Salon de Usos Multiples, CIA 1 y 2 ")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.todoss))
        );

        mMap.addMarker(new MarkerOptions()
                .position(copilco)
                .title("Metro Copilco")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.copilco))
        );

        mMap.addMarker(new MarkerOptions()
                .position(muni)
                .title("Metro Universidad")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.muni))
        );

        mMap.addMarker(new MarkerOptions()
                .position(cele)
                .title("Autobus Escolar(pumabús) CELE")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cele))
        );


        mMap.addMarker(new MarkerOptions()
                .position(anexo)
                .title("Autobus Escolar(pumabús) Anexo de Ingeniería")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pumaanexo))
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(AuditorioUno, 17));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mMap.setMyLocationEnabled(true);
    }
}
