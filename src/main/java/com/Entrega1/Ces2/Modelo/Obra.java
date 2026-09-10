package com.Entrega1.Ces2.Modelo;

public class Obra {
    private String nombre;
    private String autor;
    private int anio;

    public Obra(String nombre, String autor, int anio) {
        this.nombre = nombre;
        this.autor = autor;
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }
}
