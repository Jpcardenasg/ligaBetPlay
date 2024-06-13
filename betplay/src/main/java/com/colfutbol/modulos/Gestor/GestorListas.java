package com.colfutbol.modulos.Gestor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.colfutbol.modulos.Cuerpo.CuerpoMedico;
import com.colfutbol.modulos.Cuerpo.CuerpoTecnico;
import com.colfutbol.modulos.Equipo.Equipo;
import com.colfutbol.modulos.Jugador.Jugador;
import com.colfutbol.modulos.Partido.Partido;

public class GestorListas {
    private List<Equipo> equipos;
    private List<Partido> partidos;
    private List<Jugador> jugadores;
    private List<CuerpoMedico> cuerpoMedico;
    private List<CuerpoTecnico> cuerpoTecnico;

    public GestorListas() {
        jugadores = new ArrayList<>();
        equipos = new ArrayList<>();
        partidos = new ArrayList<>();
        cuerpoMedico = new ArrayList<>();
        cuerpoTecnico = new ArrayList<>();
    }

    public void addJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void addEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public void addPartido(Partido partido) {
        partidos.add(partido);
    }

    public void addCuerpoMedico(CuerpoMedico cMedico) {
        cuerpoMedico.add(cMedico);
    }

    public void addCuerpoTecnico(CuerpoTecnico cTecnico) {
        cuerpoTecnico.add(cTecnico);
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public List<CuerpoMedico> getCuerpoMedicos() {
        return cuerpoMedico;
    }

    public List<CuerpoTecnico> getCuerpoTecnico() {
        return cuerpoTecnico;
    }

    public boolean existeCuerpoTecnico(int id) {
        for (CuerpoTecnico tecnico : cuerpoTecnico) {
            if (tecnico.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean existeCuerpoMedico(int id) {
        for (CuerpoMedico medico : cuerpoMedico) {
            if (medico.getId() == id) {
                return true;
            }
        }
        return false;
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
