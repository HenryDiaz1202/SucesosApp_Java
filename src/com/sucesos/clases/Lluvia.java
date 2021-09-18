package com.sucesos.clases;

import java.time.LocalDate;

public class Lluvia extends Suceso {


    public int milimetros;
    public String tipo_lluvia;

    public int getMilimetros() {return milimetros;}

    public void setMilimetros(int milimetros) {
        this.milimetros = milimetros;
    }

    public String getTipo_lluvia() { return tipo_lluvia;}

    public void setTipo_lluvia(String tipo_lluvia) {
        this.tipo_lluvia = tipo_lluvia;
    }

    public Lluvia(){

    }
    public Lluvia(int mm, String tipo, LocalDate fecha_suceso, float duracion)
    {
        super(fecha_suceso,duracion);
    }

}
