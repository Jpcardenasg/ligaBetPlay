package com.colfutbol.modulos.Jugador;

import java.util.ArrayList;
import java.util.List;

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
