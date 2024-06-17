package com.colfutbol.Equipo.domain;

import java.util.ArrayList;
import java.util.List;

import com.colfutbol.Jugador.domain.Jugador;
import com.colfutbol.Persona.Persona;

public class Equipo {

    private String nombre;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosPerdidos;
    private int partidosEmpatados;
    private int golesFavor;
    private int golesContra;
    private int puntos;
    private List<Jugador> jugadores;
    private List<Persona> cuerpoTecnico;
    private List<Persona> cuerpoMedico;

    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
        this.cuerpoMedico = new ArrayList<>();
        this.cuerpoTecnico = new ArrayList<>();
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public List<Persona> getCuerpoTecnico() {
        return cuerpoTecnico;
    }

    public void agregarCuerpoTecnico(Persona persona) {
        cuerpoTecnico.add(persona);
    }

    public List<Persona> getCuerpoMedico() {
        return cuerpoMedico;
    }

    public void agregarCuerpoMedico(Persona persona) {
        cuerpoMedico.add(persona);
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
