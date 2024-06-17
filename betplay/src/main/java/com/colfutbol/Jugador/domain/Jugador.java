package com.colfutbol.Jugador.domain;

import com.colfutbol.Persona.Persona;

public class Jugador extends Persona {

    private int dorsal;
    private String posicion;
    private String equipo;
    private int golesAnotados;
    private int totalTarjetaRoja;
    private int totalTarjetaAmarilla;
    private static int contadorJugadores;

    public Jugador() {
    }

    public Jugador(int id, String nombre, String apellidos, int edad, String nacionalidad, int dorsal, String posicion,
            String equipo) {

        super(id, nombre, apellidos, edad, nacionalidad);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.equipo = equipo;
        this.golesAnotados = 0;
        ++Jugador.contadorJugadores;
    }

    public static int totalJugadores() {
        return Jugador.contadorJugadores;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int goles) {
        this.golesAnotados += goles;
    }

    public int getTotalTarjetaRoja() {
        return totalTarjetaRoja;
    }

    public int getTotalTarjetaAmarilla() {
        return totalTarjetaAmarilla;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", posicion='" + posicion + '\'' +
                ", numero=" + dorsal +
                ", equipo='" + equipo + '\'' +
                '}';
    }
}
