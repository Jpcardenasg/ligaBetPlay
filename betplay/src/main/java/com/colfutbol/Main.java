package com.colfutbol;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static Equipo registrarEquipo() {
        System.out.println("Ingrese el nombre del equipo:");
        String input = sc.nextLine();
        return new Equipo(input);
    }

    public static Partido registrarPartido(ArrayList<Equipo> equipos) {
        System.out.println("Ingrese el año del partido:");
        String year = sc.nextLine();
        System.out.println("Ingrese el mes del partido:");
        String month = sc.nextLine();
        System.out.println("Ingrese el día del partido:");
        String day = sc.nextLine();

        String fechaPartido = String.format("%s-%s-%s", year, month, day);

        System.out.println("Seleccione el equipo local:");
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println(i + 1 + ". " + equipos.get(i).getNombre());
        }
        int indexLocal = Integer.parseInt(sc.nextLine()) - 1;

        System.out.println("Seleccione el equipo visitante:");
        for (int i = 0; i < equipos.size(); i++) {
            if (i != indexLocal) {
                System.out.println(i + 1 + ". " + equipos.get(i).getNombre());
            }
        }
        int indexVisitante = Integer.parseInt(sc.nextLine()) - 1;

        System.out.println("Ingrese los goles del equipo local:");
        int golesLocal = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese los goles del equipo visitante:");
        int golesVisitante = Integer.parseInt(sc.nextLine());

        return new Partido(fechaPartido, equipos.get(indexLocal), equipos.get(indexVisitante), golesLocal,
                golesVisitante);
    }

    public static void menuReportes() {

    }

    public static void main(String[] args) {

        ArrayList<Equipo> equipos = new ArrayList<>();
        ArrayList<Partido> partidos = new ArrayList<>();

        System.out.println("Bienvenido al sistema de administración de la liga BetPlay:");
        System.out.println(
                "Ingrese alguna de las siguientes opciones:\n1.Registrar Equipo\n2.Registrar partido\n3.Reportes\n0.Salir");

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        Integer opcion = Integer.parseInt(sc.nextLine());

        boolean flag = true;

        while (flag) {
            switch (opcion) {
                case 1:
                    Equipo nuevoEquipo = registrarEquipo();
                    equipos.add(nuevoEquipo);
                    System.out.println(String.format("El equipo %s se agregó correctamente", nuevoEquipo.getNombre()));
                    break;
                case 2:
                    Partido nuevoPartido = registrarPartido(equipos);
                    partidos.add(nuevoPartido);
                    nuevoPartido.asignarPuntos();
                    System.out.println("Partido registrado correctamente.");
                    break;
                case 3:
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

    }
}