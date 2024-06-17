package com.colfutbol.Partido.domain;

import com.colfutbol.Equipo.domain.Equipo;

public class Partido {

    private String fechaPartido;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Integer golesEquipoLocal;
    private Integer golesEquipoVisitante;

    public Partido(String fechaPartido, Equipo equipoLocal, Equipo equipoVisitante, Integer golesEquipoLocal,
            Integer golesEquipoVisitante) {

        this.fechaPartido = fechaPartido;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    public void asignarPuntos() {

        if (this.golesEquipoLocal == this.golesEquipoVisitante) {
            this.equipoLocal.partidoEmpatado(golesEquipoLocal, golesEquipoVisitante);
            this.equipoVisitante.partidoEmpatado(golesEquipoVisitante, golesEquipoLocal);

        } else if (this.golesEquipoLocal > this.golesEquipoVisitante) {
            this.equipoLocal.partidoGanado(golesEquipoLocal, golesEquipoVisitante);
            this.equipoVisitante.partidoPerdido(golesEquipoVisitante, golesEquipoLocal);

        } else {
            this.equipoLocal.partidoPerdido(golesEquipoLocal, golesEquipoVisitante);
            this.equipoVisitante.partidoGanado(golesEquipoVisitante, golesEquipoLocal);
        }
    }

    public String getFechaPartido() {
        return fechaPartido;
    }
}
