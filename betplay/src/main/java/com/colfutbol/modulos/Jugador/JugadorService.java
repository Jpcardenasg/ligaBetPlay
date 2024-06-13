package com.colfutbol.modulos.Jugador;

import java.util.List;
import java.util.Scanner;

import com.colfutbol.modulos.Equipo.Equipo;
import com.colfutbol.modulos.Gestor.GestorListas;

public class JugadorService {

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
        equipos.get(opcionEquipo).agregarJugador(nuevoJugador);

        return nuevoJugador;
    }
}
