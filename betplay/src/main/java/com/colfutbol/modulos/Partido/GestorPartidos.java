package com.colfutbol.modulos.Partido;

import java.util.ArrayList;
import java.util.List;

public class GestorPartidos {
    private List<Partido> partidos;

    public GestorPartidos() {
        partidos = new ArrayList<>();
    }

    public void addPartido(Partido partido) {
        partidos.add(partido);
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

}
