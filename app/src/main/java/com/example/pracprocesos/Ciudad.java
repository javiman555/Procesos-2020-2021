package com.example.pracprocesos;

import java.util.ArrayList;

public class Ciudad {

    private String nombre;
    private String comunidad;
    private int poblacion;
    private float densidad;
    private int sanos;
    private int infectados;
    private int totalsanitario;
    private int hospitalizados;
    private ArrayList<String> colindantes;

    public Ciudad(String nombre, String comunidad, float densidad, int poblacion, int sanos, int infectados, int totalsanitario, int hospitalizados, ArrayList<String> colindantes) {
        this.nombre = nombre;
        this.comunidad = comunidad;
        this.poblacion = poblacion;
        this.densidad = densidad;
        this.sanos = sanos;
        this.infectados = infectados;
        this.totalsanitario = totalsanitario;
        this.hospitalizados = hospitalizados;
        this.colindantes = colindantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public float getDensidad() {
        return densidad;
    }

    public void setDensidad(int densidad) {
        this.densidad = densidad;
    }

    public int getSanos() {
        return sanos;
    }

    public void setSanos(int sanos) {
        this.sanos = sanos;
    }

    public int getInfectados() {
        return infectados;
    }

    public void setInfectados(int infectados) {
        this.infectados = infectados;
    }

    public int getTotalsanitario() {
        return totalsanitario;
    }

    public void setTotalsanitario(int totalsanitario) {
        this.totalsanitario = totalsanitario;
    }

    public int getHospitalizados() {
        return hospitalizados;
    }

    public void setHospitalizados(int hospitalizados) {
        this.hospitalizados = hospitalizados;
    }

    public ArrayList<String> getColindantes() {
        return colindantes;
    }

    public void setColindantes(ArrayList<String> colindantes) {
        this.colindantes = colindantes;
    }
}
