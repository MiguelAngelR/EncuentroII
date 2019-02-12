package com.eii.encuentroii.model;

import android.app.Activity;
import android.media.Image;

/**
 * Created by Michael Liebheart on 20/03/2018.
 */

public class conferencia {

    private String titulo;
    private String lugar;
    private String hora;
    private String conferencista;

    public conferencia(String titulo, String lugar, String hora, String conferencista) {
        this.titulo = titulo;
        this.lugar = lugar;
        this.hora = hora;
        this.conferencista = conferencista;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getConferencista() {
        return conferencista;
    }

    public void setConferencista(String conferencista) {
        this.conferencista = conferencista;
    }
}
