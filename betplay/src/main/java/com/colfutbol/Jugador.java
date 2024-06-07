package com.colfutbol;

import java.util.List;
import java.util.Scanner;

public class Jugador extends Persona {

    private int dorsal;
    private String posicion;
    private String equipo;
    // private int golesAnotados;
    // private int totalTarjetaRoja;
    // private int totalTarjetaAmarilla;
    private static int contadorJugadores;

    public Jugador() {
    }

    public Jugador(int id, String nombre, String apellidos, int edad, String nacionalidad, int dorsal, String posicion,
            String equipo) {

        super(id, nombre, apellidos, edad, nacionalidad);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.equipo = equipo;
        ++Jugador.contadorJugadores;
    }

    public static Jugador registrarJugador(Scanner sc, GestorListas gestor) {

        System.out.println("Ingrese el Número de Identificación:\n");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el Nombre:\n");
        String nombre = sc.nextLine();

        System.out.println("Ingrese los Apellidos:\n");
        String apellidos = sc.nextLine();

        System.out.println("Ingrese la Edad:\n");
        int edad = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese la Nacionalidad:\n");
        String nacionalidad = sc.nextLine();

        System.out.println("Ingrese el número del dorsal:\n");
        int dorsal = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese la posición del jugador:\n");
        String posicion = sc.nextLine();

        System.out.println("Escoja a qué equipo pertenece:\n");
        List<Equipo> equipos = gestor.getEquipos();

        for (int i = 0; i < equipos.size(); i++) {
            System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
        }

        int opcionEquipo = Integer.parseInt(sc.nextLine()) - 1;
        String equipo = equipos.get(opcionEquipo).getNombre();

        Jugador nuevoJugador = new Jugador(id, nombre, apellidos, edad, nacionalidad, dorsal, posicion, equipo);
        gestor.addJugador(nuevoJugador);
        equipos.get(opcionEquipo).agregarJugador(nuevoJugador);

        return nuevoJugador;
    }

    public static int totalJugadores() {
        return Jugador.contadorJugadores;
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
