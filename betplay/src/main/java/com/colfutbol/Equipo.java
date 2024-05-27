package com.colfutbol;

public class Equipo {

    private String nombre;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosPerdidos;
    private int partidosEmpatados;
    private int golesFavor;
    private int golesContra;
    private int puntos;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public void partidoGanado(int golesFavor, int golesContra) {
        this.partidosJugados++;
        this.partidosGanados++;
        setPuntos(3);
        setGolesFavor(golesFavor);
        setGolesContra(golesContra);
    }

    public void partidoEmpatado(int golesFavor, int golesContra) {
        this.partidosJugados++;
        this.partidosEmpatados++;
        setPuntos(1);
        setGolesFavor(golesFavor);
        setGolesContra(golesContra);
    }

    public void partidoPerdido(int golesFavor, int golesContra) {
        this.partidosJugados++;
        this.partidosPerdidos++;
        setGolesFavor(golesFavor);
        setGolesContra(golesContra);
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos += puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor += golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra += golesContra;
    }

}
