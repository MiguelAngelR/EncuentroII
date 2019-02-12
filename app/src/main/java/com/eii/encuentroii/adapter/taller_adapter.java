package com.eii.encuentroii.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.eii.encuentroii.R;
import com.eii.encuentroii.model.talleres;

import java.util.ArrayList;

/**
 * Created by Michael Liebheart on 21/03/2018.
 */

public class taller_adapter extends RecyclerView.Adapter<taller_adapter.tallerViewHolder> {

    private static ArrayList<talleres> taller;
    private int resources;
    private Activity activity;

    public taller_adapter (ArrayList<talleres> taller , int resources , Activity activity) {
        this.resources = resources;
        this.taller = taller;
        this.activity = activity;
    }


    @Override
    public tallerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resources,parent,false);
        return new tallerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(tallerViewHolder holder, int position) {
        talleres talleres = taller.get(position);
        holder.tvTituloTaller.setText(talleres.getTitulo());
        holder.tvTallerista.setText(talleres.getTallerista());
        holder.capacidad.setText(talleres.getCapacidad());
        holder.lugar.setText(talleres.getLugar());
        holder.horario.setText(talleres.getHora());

    }

    @Override
    public int getItemCount() {
        return taller.size();
    }


    public class tallerViewHolder extends RecyclerView.ViewHolder{
        private ImageButton imbTaller;
        private TextView tvTituloTaller;
        private TextView tvTallerista;
        private TextView capacidad;
        private TextView lugar;
        private TextView horario;

        public tallerViewHolder(View itemView) {
            super(itemView);

            imbTaller = (ImageButton)itemView.findViewById(R.id.imbTaller);
            tvTituloTaller = (TextView)itemView.findViewById(R.id.tvTituloTaller);
            tvTallerista = (TextView)itemView.findViewById(R.id.tvImparteTaller);
            capacidad = (TextView)itemView.findViewById(R.id.tvCupoTaller);
            lugar = (TextView)itemView.findViewById(R.id.tvLugarTaller);
            horario = (TextView)itemView.findViewById(R.id.tvHoraTaller);
        }
    }

}
