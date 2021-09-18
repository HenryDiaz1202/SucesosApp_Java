package com.sucesos.clases;

import java.time.LocalDate;

public class Temblor extends Suceso{

    int longitud;
    int latitud;
    float escala_ritcher;


    public int getLatitud(){return  this.latitud;}

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public int getLongitud(){ return this.longitud;}

    public void setLongitud( int longitud) { this.longitud=longitud; }

    public float getEscala_ritcher() { return escala_ritcher; }

    public void setEscala_ritcher(float escala_ritcher) {
        this.escala_ritcher = escala_ritcher;
    }

    public Temblor() {
        super();
    }

    public Temblor(int lat, int longit, float escala, LocalDate fecha, float dur)
    {
        super(fecha, dur);
    }

}
