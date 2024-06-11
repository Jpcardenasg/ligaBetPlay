package com.colfutbol;

import java.util.Scanner;

public class CuerpoMedico extends Persona {

    private String rol;
    private String especialidad;
    private int experiencia;

    public CuerpoMedico() {
    }

    public CuerpoMedico(int id, String nombre, String apellidos, int edad, String nacionalidad, String rol,
            String especialidad, int experiencia) {
        super(id, nombre, apellidos, edad, nacionalidad);
        this.rol = rol;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
    }

    public static CuerpoMedico registrarCuerpoMedico(Scanner sc, GestorListas gestor) {

        System.out.println("Ingrese el Número de Identificación:\n");
        int id = Integer.parseInt(sc.nextLine());

        if (gestor.existeCuerpoMedico(id)) {
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

        return new CuerpoMedico(id, nombre, apellidos, edad, nacionalidad, rol, especialidad, experiencia);
    }

    @Override
    public String toString() {
        return "CuerpoMedico{" +
                "rol='" + rol + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", añosExperiencia=" + experiencia +
                '}';
    }
}
