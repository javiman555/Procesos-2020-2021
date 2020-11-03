package com.example.pracprocesos;

public class Ciudad {

    private String nombre;
    private String comunidad;
    private int poblacion;
    private int sanos;
    private int infectados;
    private int totalsanitario;
    private int hospitalizados;

    public Ciudad(String nombre, String comunidad, int poblacion, int sanos, int infectados, int totalsanitario, int hospitalizados) {
        this.nombre = nombre;
        this.comunidad = comunidad;
        this.poblacion = poblacion;
        this.sanos = sanos;
        this.infectados = infectados;
        this.totalsanitario = totalsanitario;
        this.hospitalizados = hospitalizados;
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

    
}
