package com.example.pracprocesos;

import java.io.Serializable;

public class Virus implements Serializable {

    private String nombre;
    private int sanos;
    private int infectados;
    private int muertos;
    //Ratio de conversion infectados--> muertos
    private double mortalidad;
    //Indices de propagación segun conexión
    private double R;
    private double Rtierra;
    private double Raire;
    private double Rmar;

    public Virus(String nombre){
        this.nombre = nombre;
        this.sanos = 10921241;
        this.infectados = 0;
        this.muertos = 0;
        this.mortalidad=0.05;
        this.R = 1.5;
        this.Rtierra= R;
        this.Raire= R*0.5;
        this.Rmar= R*2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public double getMortalidad() {
        return mortalidad;
    }

    public void setMortalidad(double mortalidad) {
        this.mortalidad = mortalidad;
    }

    public double getR() {
        return R;
    }

    public void setR(double r) {
        R = r;
    }

    public double getRtierra() {
        return Rtierra;
    }

    public void setRtierra(double rtierra) {
        Rtierra = rtierra;
    }

    public double getRaire() {
        return Raire;
    }

    public void setRaire(double raire) {
        Raire = raire;
    }

    public double getRmar() {
        return Rmar;
    }

    public void setRmar(double rmar) {
        Rmar = rmar;
    }
}
