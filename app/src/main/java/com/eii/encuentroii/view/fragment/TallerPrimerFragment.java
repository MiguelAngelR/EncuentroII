package com.eii.encuentroii.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.eii.encuentroii.R;
import com.eii.encuentroii.adapter.conf_adapter;
import com.eii.encuentroii.adapter.taller_adapter;
import com.eii.encuentroii.model.conferencia;
import com.eii.encuentroii.model.talleres;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TallerPrimerFragment extends Fragment {
    Toolbar toolbar;
    RecyclerView RvTaller;
    LinearLayoutManager llayout;


    public TallerPrimerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_taller_primer, container, false);
        muestraToolbar(getResources().getString(R.string.tTallerPrimer),false, view);
        createRecyclerView(view);
        return view;
    }

    public ArrayList<talleres> buildTaller (){
        ArrayList<talleres> talleres = new ArrayList<>();  // titulo , capacidad, lugar , hora, tallerista
        talleres.add(new talleres(getResources().getString(R.string.TitleTaller1_dia1),getResources().getString(R.string.CapacidadTaller1_dia1), getResources().getString(R.string.CIA1),getResources().getString(R.string.HoraTaller1_dia1),getResources().getString(R.string.ImparteTaller1_dia1)));
        talleres.add(new talleres(getResources().getString(R.string.TitleTaller2_dia1),getResources().getString(R.string.CapacidadTaller2_dia1), getResources().getString(R.string.CIA1),getResources().getString(R.string.HoraTaller2_dia1),getResources().getString(R.string.ImparteTaller2_dia1)));
        talleres.add(new talleres(getResources().getString(R.string.TitleTaller3_dia1),getResources().getString(R.string.CapacidadTaller3_dia1), getResources().getString(R.string.CIA1),getResources().getString(R.string.HoraTaller3_dia1),getResources().getString(R.string.ImparteTaller3_dia1)));
        talleres.add(new talleres(getResources().getString(R.string.TitleTaller4_dia1),getResources().getString(R.string.CapacidadTaller4_dia1), getResources().getString(R.string.CIA2),getResources().getString(R.string.HoraTaller4_dia1),getResources().getString(R.string.ImparteTaller4_dia1)));
        talleres.add(new talleres(getResources().getString(R.string.TitleTaller5_dia1),getResources().getString(R.string.CapacidadTaller5_dia1), getResources().getString(R.string.CIA2),getResources().getString(R.string.HoraTaller5_dia1),getResources().getString(R.string.ImparteTaller5_dia1)));
        talleres.add(new talleres(getResources().getString(R.string.TitleTaller6_dia1),getResources().getString(R.string.CapacidadTaller6_dia1), getResources().getString(R.string.UM),getResources().getString(R.string.HoraTaller6_dia1),getResources().getString(R.string.ImparteTaller6_dia1)));
        talleres.add(new talleres(getResources().getString(R.string.TitleTaller7_dia1),getResources().getString(R.string.CapacidadTaller7_dia1), getResources().getString(R.string.UM),getResources().getString(R.string.HoraTaller7_dia1),getResources().getString(R.string.ImparteTaller7_dia1)));


        return talleres;
    }


    public void muestraToolbar(String titulo , boolean upBotton, View view){

        toolbar = (Toolbar)view.findViewById(R.id.toolbar2);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);

    }

    public void createRecyclerView(View view){
        RvTaller = (RecyclerView)view.findViewById(R.id.rvTallerPrimero);
        llayout = new LinearLayoutManager(view.getContext());
        llayout.setOrientation(LinearLayoutManager.VERTICAL);
        RvTaller.setLayoutManager(llayout);

        taller_adapter tallerAdapter = new taller_adapter(buildTaller(),R.layout.cardview_taller,null);
        //  conf_adapter conf_adapter = new conf_adapter(buildConferencias(), R.layout.cardview_conftaller, getCallingActivity());
        RvTaller.setAdapter(tallerAdapter);
    }


}
