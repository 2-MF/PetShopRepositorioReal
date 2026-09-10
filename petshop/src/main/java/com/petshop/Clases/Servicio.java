package com.petshop.Clases;
public class Servicio {

    private int id;
    private String perro;
    private String servicio;
    private String horario;
    private double precio;
    private String limpiador;

    public Servicio(String perro, String servicio,
                    String horario, double precio,
                    String limpiador) {

        this.perro = perro;
        this.servicio = servicio;
        this.horario = horario;
        this.precio = precio;
        this.limpiador = limpiador;
    }

    public int getId() {
        return id;
    }

    public String getPerro() {
        return perro;
    }

    public String getServicio() {
        return servicio;
    }

    public String getHorario() {
        return horario;
    }

    public double getPrecio() {
        return precio;
    }

    public String getLimpiador() {
        return limpiador;
    }
}