package com.colfutbol.modulos.Equipo;

import java.util.Scanner;

public class EquipoService {

    public static Equipo registrarEquipo(Scanner sc) {
        System.out.println("Ingrese el nombre del equipo:");
        String nombre = sc.nextLine();
        return new Equipo(nombre);
    }
}
