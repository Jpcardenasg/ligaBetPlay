package com.colfutbol.CuerpoTecnico.application;

import java.util.Scanner;

import com.colfutbol.CuerpoTecnico.domain.CuerpoTecnico;
import com.colfutbol.modulos.Gestor.GestorListas;

public class RegistroService {

    public static CuerpoTecnico registrarCuerpoTecnico(Scanner sc, GestorListas gestor) {
        System.out.println("Ingrese el Número de Identificación:\n");
        int id = Integer.parseInt(sc.nextLine());

        if (gestor.existeCuerpoTecnico(id)) {
            System.out.println("El profesional del cuerpo médico con el mismo ID ya está registrado.");
            return null;
        }

        System.out.println("Ingrese el Nombre:\n");
        String nombre = sc.nextLine();

        System.out.println("Ingrese los Apellidos:\n");
        String apellidos = sc.nextLine();

        System.out.println("Ingrese la Edad:\n");
        int edad = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese la Nacionalidad:\n");
        String nacionalidad = sc.nextLine();

        System.out.println("Ingrese el Rol (e.g., Doctor, Fisioterapeuta, Nutricionista):\n");
        String rol = sc.nextLine();

        System.out.println("Ingrese la Especialidad:\n");
        String especialidad = sc.nextLine();

        System.out.println("Ingrese los Años de Experiencia:\n");
        int experiencia = Integer.parseInt(sc.nextLine());

        return new CuerpoTecnico(id, nombre, apellidos, edad, nacionalidad, rol, especialidad, experiencia);
    }
}
