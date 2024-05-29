package com.colfutbol;

import java.util.ArrayList;

public class Reporte {

    ArrayList<Equipo> listaEquipos;

    public Reporte() {
        listaEquipos = new ArrayList<>();
    }

    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void addEquipo(Equipo equipo) {
        listaEquipos.add(equipo);
    }

    public Equipo equipoConMasGoles() {
        if (listaEquipos.isEmpty()) {
            return null;
        }

        Equipo pivote = listaEquipos.get(0);
        for (Equipo equipo : listaEquipos) {
            boolean condicion = equipo.getGolesFavor() > pivote.getGolesFavor();

            if (condicion) {
                pivote = equipo;
            }
        }
        return pivote;
    }

    public Equipo equipoConMasPuntos() {
        if (listaEquipos.isEmpty()) {
            return null;
        }

        Equipo pivote = listaEquipos.get(0);
        for (Equipo equipo : listaEquipos) {
            boolean condicion = equipo.getPuntos() > pivote.getPuntos();

            if (condicion) {
                pivote = equipo;
            }
        }
        return pivote;
    }

    public Equipo equipoConMasPartidosGanados() {
        if (listaEquipos.isEmpty()) {
            return null;
        }

        Equipo pivote = listaEquipos.get(0);
        for (Equipo equipo : listaEquipos) {
            boolean condicion = equipo.getPartidosGanados() > pivote.getPartidosGanados();

            if (condicion) {
                pivote = equipo;
            }
        }
        return pivote;
    }

    public int golesTotales() {
        int golesTotales = 0;
        for (Equipo equipo : listaEquipos) {
            golesTotales += equipo.getGolesFavor();
        }
        return golesTotales;
    }

    public int promedioGoles() {
        if (listaEquipos.isEmpty()) {
            return 0;
        }
        int goles = golesTotales();
        return goles / listaEquipos.size();
    }

}
