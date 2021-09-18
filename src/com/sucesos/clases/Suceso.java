package com.sucesos.clases;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Suceso  {

    LocalDateTime fecha_hora_suceso;
    float duracion;


    public LocalDateTime getFecha_hora_suceso() { return this.fecha_hora_suceso; }

    public void setFecha_hora_suceso(LocalDateTime fecha_hora_suceso) {
        this.fecha_hora_suceso = fecha_hora_suceso;
    }

    public void setDuracion(float duracion) { this.duracion = duracion; }

    public float getDuracion() { return this.duracion;}

    public Suceso(){}

    public Suceso(LocalDate fecha_hora_suceso, float dur)
    {

    }
}
