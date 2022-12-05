package com.example.ef_g1.model.beans;

public class Impresion3D {
    private int densidad;
    private String grosor;
    private double altura;
    private String material;
    private String url;
    private String autoservicio;

    public int getDensidad() {
        return densidad;
    }

    public void setDensidad(int densidad) {
        this.densidad = densidad;
    }

    public String getGrosor() {
        return grosor;
    }

    public void setGrosor(String grosor) {
        this.grosor = grosor;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAutoservicio() {
        return autoservicio;
    }

    public void setAutoservicio(String autoservicio) {
        this.autoservicio = autoservicio;
    }
}
