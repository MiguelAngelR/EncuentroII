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

import com.eii.encuentroii.R;
import com.eii.encuentroii.adapter.conf_adapter;
import com.eii.encuentroii.model.conferencia;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConferenciaPrimerFragment extends Fragment {

    Toolbar toolbar;
    RecyclerView Rvconferencias;
    LinearLayoutManager llayout;

    public ConferenciaPrimerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_conferencia_primer, container, false);
        muestraToolbar(getResources().getString(R.string.tConfPrimer),false, view);
        createRecyclerView(view);
        return view;

    }


    public ArrayList<conferencia> buildConferencias (){
        ArrayList<conferencia> conferencia = new ArrayList<>();
        conferencia.add(new conferencia(getResources().getString(R.string.TitleConferencia1_dia1), getResources().getString(R.string.AJBS),getResources().getString(R.string.HoraConferencia1_dia1),getResources().getString(R.string.ImparteConferencia1_dia1)));
        conferencia.add(new conferencia(getResources().getString(R.string.TitleConferencia2_dia1), getResources().getString(R.string.AJBS),getResources().getString(R.string.HoraConferencia2_dia1),getResources().getString(R.string.ImparteConferencia2_dia1)));
        conferencia.add(new conferencia(getResources().getString(R.string.TitleConferencia3_dia1), getResources().getString(R.string.AJBS),getResources().getString(R.string.HoraConferencia3_dia1),getResources().getString(R.string.ImparteConferencia3_dia1)));
        conferencia.add(new conferencia(getResources().getString(R.string.TitleConferencia4_dia1), getResources().getString(R.string.AJBS),getResources().getString(R.string.HoraConferencia4_dia1),getResources().getString(R.string.ImparteConferencia4_dia1)));
        conferencia.add(new conferencia(getResources().getString(R.string.TitleConferencia5_dia1), getResources().getString(R.string.AJBS),getResources().getString(R.string.HoraConferencia5_dia1),getResources().getString(R.string.ImparteConferencia5_dia1)));
        conferencia.add(new conferencia(getResources().getString(R.string.TitleConferencia6_dia1), getResources().getString(R.string.ARLM),getResources().getString(R.string.HoraConferencia6_dia1),getResources().getString(R.string.ImparteConferencia6_dia1)));
        conferencia.add(new conferencia(getResources().getString(R.string.TitleConferencia7_dia1), getResources().getString(R.string.ARLM),getResources().getString(R.string.HoraConferencia7_dia1),getResources().getString(R.string.ImparteConferencia7_dia1)));
        conferencia.add(new conferencia(getResources().getString(R.string.TitleConferencia8_dia1), getResources().getString(R.string.ARLM),getResources().getString(R.string.HoraConferencia8_dia1),getResources().getString(R.string.ImparteConferencia8_dia1)));
        conferencia.add(new conferencia(getResources().getString(R.string.TitleConferencia9_dia1), getResources().getString(R.string.ARLM),getResources().getString(R.string.HoraConferencia9_dia1),getResources().getString(R.string.ImparteConferencia9_dia1)));
        conferencia.add(new conferencia(getResources().getString(R.string.TitleConferencia10_dia1), getResources().getString(R.string.ARLM),getResources().getString(R.string.HoraConferencia10_dia1),getResources().getString(R.string.ImparteConferencia10_dia1)));

        return conferencia;
    }


    public void muestraToolbar(String titulo , boolean upBotton, View view){

        toolbar = (Toolbar)view.findViewById(R.id.toolbar2);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
       ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);
       ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);

    }

    public void createRecyclerView(View view){
        Rvconferencias = (RecyclerView)view.findViewById(R.id.rvConferenciasPrimero);
        llayout = new LinearLayoutManager(view.getContext());
        llayout.setOrientation(LinearLayoutManager.VERTICAL);
        Rvconferencias.setLayoutManager(llayout);

        conf_adapter confadapter = new conf_adapter(buildConferencias(),R.layout.cardview_conftaller,null);
        //  conf_adapter conf_adapter = new conf_adapter(buildConferencias(), R.layout.cardview_conftaller, getCallingActivity());
        Rvconferencias.setAdapter(confadapter);
    }


}
