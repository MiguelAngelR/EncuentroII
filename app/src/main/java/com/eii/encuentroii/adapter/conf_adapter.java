package com.eii.encuentroii.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.eii.encuentroii.MainActivity;
import com.eii.encuentroii.R;
import com.eii.encuentroii.contacto;
import com.eii.encuentroii.model.conferencia;

import java.util.ArrayList;

/**
 * Created by Michael Liebheart on 20/03/2018.
 */

public class conf_adapter extends RecyclerView.Adapter<conf_adapter.confViewHolder>{

    private ArrayList<conferencia> conferencias;
    private int resource;
    private Activity activity;

    public conf_adapter(ArrayList<conferencia> conferencias, int resource, Activity activity) {
        this.conferencias = conferencias;
        this.resource = resource;
        this.activity = activity;
    }


    @Override
    public confViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new confViewHolder(view);
    }

    @Override
    public void onBindViewHolder(confViewHolder holder, int position) {

        conferencia conferencia = conferencias.get(position);
        holder.tvTituloConf.setText(conferencia.getTitulo());
        holder.tvHoraConf.setText(conferencia.getHora());
        holder.tvLugarConf.setText(conferencia.getLugar());
        holder.tvConferencista.setText(conferencia.getConferencista());
    }

    @Override
    public int getItemCount() {
        return conferencias.size();
    }

    public class confViewHolder extends RecyclerView.ViewHolder{

        private ImageButton imbConferencia;
        private TextView    tvTituloConf;
        private TextView    tvHoraConf;
        private TextView    tvLugarConf;
        private TextView    tvConferencista;

            public confViewHolder(View itemView)
            {
            super(itemView);

            imbConferencia = (ImageButton)itemView.findViewById(R.id.imbConfTaller);
            tvTituloConf = (TextView)itemView.findViewById(R.id.tvTituloConfTaller);
            tvHoraConf = (TextView)itemView.findViewById(R.id.tvHoraConfTaller);
            tvLugarConf = (TextView)itemView.findViewById(R.id.tvLugarConfTaller);
            tvConferencista = (TextView)itemView.findViewById(R.id.tvImparteConfTaller);
            }
    }
}
