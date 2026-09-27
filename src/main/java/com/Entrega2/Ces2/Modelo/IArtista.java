package com.Entrega2.Ces2.Modelo;

import java.util.List;

public interface IArtista extends IBocetador, IPintor, IExhibidor {
    String getNombre();
    List<Obra> getObras();
}
