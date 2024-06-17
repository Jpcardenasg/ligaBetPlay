package com.colfutbol.Partido.application;

import java.util.ArrayList;
import java.util.List;

import com.colfutbol.Partido.domain.Partido;

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
