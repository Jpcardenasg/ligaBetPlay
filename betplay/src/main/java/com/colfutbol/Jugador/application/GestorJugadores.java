package com.colfutbol.Jugador.application;

import java.util.ArrayList;
import java.util.List;

import com.colfutbol.Jugador.domain.Jugador;

public class GestorJugadores {
    private List<Jugador> jugadores;

    public GestorJugadores() {
        jugadores = new ArrayList<>();
    }

    public void addJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

}
