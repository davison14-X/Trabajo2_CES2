package com.Entrega2.Ces2.Modelo;

import java.util.List;
import java.util.stream.Collectors;

public class Musico implements IArtista {
    private List<Obra> obras;
    private String nombre;

    public Musico(String nombre, List<Obra> obras) {
        this.obras = obras;
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public List<Obra> getObras() {
        return obras;
    }

    @Override
    public String bocetar(List<Obra> obras) {
        return "Misico bocetando obras: " + obras.stream()
                .map(o -> o.getNombre() + " de " + o.getAutor() + " (" + o.getAnio() + ")")
                .collect(Collectors.joining(", "));
    }

    @Override
    public String pintar(List<Obra> obras) {
        return "Musico pintando obras: " + obras.stream()
                .map(o -> o.getNombre() + " de " + o.getAutor() + " (" + o.getAnio() + ")")
                .collect(Collectors.joining(", "));
    }

    @Override
    public String exhibir(List<Obra> obras) {
        return "Musico exhibiendo obras: " + obras.stream()
                .map(o -> o.getNombre() + " de " + o.getAutor() + " (" + o.getAnio() + ")")
                .collect(Collectors.joining(", "));
    }
}
