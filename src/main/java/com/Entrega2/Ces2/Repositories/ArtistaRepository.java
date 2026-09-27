package com.Entrega2.Ces2.Repositories;

import com.Entrega2.Ces2.Modelo.*;
import java.util.List;

public class ArtistaRepository {

    public static List<IArtista> getArtistas() {
        // Obras para usar en los objetos
        Obra o1 = new Obra("La Gioconda", "Leonardo Da Vinci", 1503);
        Obra o2 = new Obra("El Grito", "Edvard Munch", 1893);
        Obra o3 = new Obra("La Noche Estrellada", "Van Gogh", 1889);
        Obra o4 = new Obra("Guernica", "Picasso", 1937);
        Obra o5 = new Obra("El Pensador", "Rodin", 1904);

        // Pintores
        Pintor p1 = new Pintor("Pintor 1", List.of());
        Pintor p2 = new Pintor("Pintor 2", List.of(o1));
        Pintor p3 = new Pintor("Pintor 3", List.of(o1, o2));
        Pintor p4 = new Pintor("Pintor 4", List.of(o1, o2, o3));

        // Escultores
        Escultor e1 = new Escultor("Escultor 1", List.of(o1, o2, o3, o4));
        Escultor e2 = new Escultor("Escultor 2", List.of(o1, o2, o3, o4, o5));
        Escultor e3 = new Escultor("Escultor 3", List.of());
        Escultor e4 = new Escultor("Escultor 4", List.of(o1));

        // Musicos
        Musico m1 = new Musico("Musico 1", List.of(o1, o2));
        Musico m2 = new Musico("Musico 2", List.of(o1, o2, o3));
        Musico m3 = new Musico("Musico 3", List.of(o1, o2, o3, o4));
        Musico m4 = new Musico("Musico 4", List.of(o1, o2, o3, o4, o5));

        return List.of(p1, p2, p3, p4, e1, e2, e3, e4, m1, m2, m3, m4);
    }
}
