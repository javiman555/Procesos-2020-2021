package com.example.pracprocesos;

import java.util.ArrayList;

public class Ciudad {

    private String nombre;
    private String comunidad;
    private int poblacion;
    private float densidad;
    private int sanos;
    private int infectados;
    private int muertos;
    private int totalsanitario;
    private int hospitalizados;
    private ArrayList<String> colindantes;
    private ArrayList<String> puertos;
    private ArrayList<String> aeropuertos;

    public Ciudad(String nombre, String comunidad, float v, float densidad, int poblacion, int sanos, int infectados, int totalsanitario, int hospitalizados, ArrayList<String> listaColindantes, ArrayList<String> listaPuertos, ArrayList<String> colindantes) {
        this.nombre = nombre;
        this.comunidad = comunidad;
        this.poblacion = poblacion;
        this.densidad = densidad;
        this.sanos = sanos;
        this.infectados = infectados;
        this.muertos = muertos;
        this.totalsanitario = totalsanitario;
        this.hospitalizados = hospitalizados;
        this.colindantes = colindantes;
        this.puertos = puertos;
        this.aeropuertos = aeropuertos;
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

    public int getMuertos() {
        return muertos;
    }

    public void setMuertos(int muertos) {
        this.muertos = muertos;
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

    public ArrayList<String> getPuertos() {
        return puertos;
    }

    public void setPuertos(ArrayList<String> puertos) {
        this.puertos = puertos;
    }

    public ArrayList<String> getAeropuertos() {
        return aeropuertos;
    }

    public void setAeropuertos(ArrayList<String> aeropuertos) {
        this.aeropuertos = aeropuertos;
    }
}
