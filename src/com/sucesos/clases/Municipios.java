package com.sucesos.clases;

import java.util.ArrayList;
import java.util.List;

public class Municipios {

    public String nombre;
    public float extension;


    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public float getExtension()
    {
        return this.extension; }

    public void setExtension(float extension) {
        this.extension = extension;
    }


    public List<Suceso> sucesos;

    public List<Suceso> getSucesos() {
        return this.sucesos;
    }

    public void setSucesos(List<Suceso> sucesos) {
        this.sucesos = sucesos;
    }

}
