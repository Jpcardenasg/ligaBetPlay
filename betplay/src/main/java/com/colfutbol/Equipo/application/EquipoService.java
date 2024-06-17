package com.colfutbol.Equipo.application;

import java.util.Scanner;

import com.colfutbol.Equipo.domain.Equipo;

public class EquipoService {

    public static Equipo registrarEquipo(Scanner sc) {
        System.out.println("Ingrese el nombre del equipo:");
        String nombre = sc.nextLine();
        return new Equipo(nombre);
    }
}
