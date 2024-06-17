package com.colfutbol.Equipo.application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.colfutbol.Equipo.domain.Equipo;

public class GestorEquipos {
    private List<Equipo> equipos;

    public GestorEquipos() {
        equipos = new ArrayList<>();
    }

    public void addEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public List<Equipo> tablaDePosiciones() {
        List<Equipo> equiposOrdenados = new ArrayList<>(equipos);
        equiposOrdenados.sort(Comparator.comparingInt(Equipo::getPuntos).reversed());
        return equiposOrdenados;
    }

    public Equipo equipoConMasGoles() {
        if (equipos.isEmpty()) {
            return null;
        }

        Equipo pivote = equipos.get(0);
        for (Equipo equipo : equipos) {
            boolean condicion = equipo.getGolesFavor() > pivote.getGolesFavor();

            if (condicion) {
                pivote = equipo;
            }
        }
        return pivote;
    }

    public Equipo equipoConMasPuntos() {
        if (equipos.isEmpty()) {
            return null;
        }

        Equipo pivote = equipos.get(0);
        for (Equipo equipo : equipos) {
            boolean condicion = equipo.getPuntos() > pivote.getPuntos();

            if (condicion) {
                pivote = equipo;
            }
        }
        return pivote;
    }

    public Equipo equipoConMasPartidosGanados() {
        if (equipos.isEmpty()) {
            return null;
        }

        Equipo pivote = equipos.get(0);
        for (Equipo equipo : equipos) {
            boolean condicion = equipo.getPartidosGanados() > pivote.getPartidosGanados();

            if (condicion) {
                pivote = equipo;
            }
        }
        return pivote;
    }

    public int golesTotales() {
        int golesTotales = 0;
        for (Equipo equipo : equipos) {
            golesTotales += equipo.getGolesFavor();
        }
        return golesTotales;
    }

    public int promedioGoles() {
        if (equipos.isEmpty()) {
            return 0;
        }
        int goles = golesTotales();
        return goles / equipos.size();
    }
}
