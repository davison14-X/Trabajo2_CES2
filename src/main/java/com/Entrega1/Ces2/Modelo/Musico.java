package com.Entrega1.Ces2.Modelo;

public class Musico implements IArtista{
    private Obra obra;

    public Musico(Obra obra) {
        this.obra = obra;
    }

    public Obra getObra() {
        return obra;
    }

    @Override
    public String bocetar(Obra obra) {
        return "El Musico " + obra.getAutor() + " ha bocetado la obra " + obra.getNombre() + " en el año " + obra.getAnio() + ".";
    }

    @Override
    public String pintar(Obra obra) {
        return "El Musico " + obra.getAutor() + " ha pintado la obra " + obra.getNombre() + " en el año " + obra.getAnio() + ".";
    }

    @Override
    public String exhibir(Obra obra) {
        return "El Musico " + obra.getAutor() + " ha exhibido la obra " + obra.getNombre() + " en el año " + obra.getAnio() + ".";
    }
}
