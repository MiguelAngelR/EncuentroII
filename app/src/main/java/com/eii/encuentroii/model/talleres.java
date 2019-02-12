package com.eii.encuentroii.model;

import android.media.Image;

/**
 * Created by Michael Liebheart on 21/03/2018.
 */

public class talleres {

    private String titulo;
    private String capacidad;
    private String lugar;
    private String hora;
    private String tallerista;

    public talleres(String titulo, String capacidad, String lugar, String hora, String tallerista) {
        this.titulo = titulo;
        this.capacidad = capacidad;
        this.lugar = lugar;
        this.hora = hora;
        this.tallerista = tallerista;
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTallerista() {
        return tallerista;
    }

    public void setTallerista(String tallerista) {
        this.tallerista = tallerista;
    }
}
