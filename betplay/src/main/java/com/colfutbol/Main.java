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
        if (equipos.size() < 2) {
            System.out.println("Se necesitan al menos dos equipos registrados para registrar un partido.");
            return null;
        }

        System.out.println("Ingrese el año del partido:");
        String year = sc.nextLine();
        System.out.println("Ingrese el mes del partido:");
        String month = sc.nextLine();
        System.out.println("Ingrese el día del partido:");
        String day = sc.nextLine();

        String fechaPartido = String.format("%s-%s-%s", year, month, day);

        System.out.println("Seleccione el equipo local:");
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
        }
        int indexLocal = -1;
        int indexVisitante = -1;

        while (true) {
            try {
                indexLocal = Integer.parseInt(sc.nextLine()) - 1;
                if (indexLocal >= 0 && indexLocal < equipos.size()) {
                    break;
                } else {
                    System.out.println("Índice no válido. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
            }
        }

        System.out.println("Seleccione el equipo visitante:");
        for (int i = 0; i < equipos.size(); i++) {
            if (i != indexLocal) {
                System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
            }
        }

        while (true) {
            try {
                indexVisitante = Integer.parseInt(sc.nextLine()) - 1;
                if (indexVisitante >= 0 && indexVisitante < equipos.size() && indexVisitante != indexLocal) {
                    break;
                } else {
                    System.out.println("Índice no válido o el mismo equipo que el local. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
            }
        }

        int golesLocal = -1;
        int golesVisitante = -1;

        System.out.println("Ingrese los goles del equipo local:");
        while (true) {
            try {
                golesLocal = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
            }
        }

        System.out.println("Ingrese los goles del equipo visitante:");
        while (true) {
            try {
                golesVisitante = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
            }
        }

        return new Partido(fechaPartido, equipos.get(indexLocal), equipos.get(indexVisitante), golesLocal,
                golesVisitante);
    }

    public static void menuReportes(Reporte equipos) {
        boolean flag = true;
        Equipo equipo;

        while (flag) {
            System.out.println(
                    "Ingrese alguna de las siguientes opciones:\n1.Equipo con más goles anotados\n2.Equipo con más puntos\n3.Equipo con más partidos ganados\n4.Total goles anotados\n5.Promedio goles anotados\n0.Salir");
            int opcion = -1;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
                continue;
            }

            switch (opcion) {
                case 1:
                    equipo = equipos.equipoConMasGoles();
                    System.out.println(String.format("El equipo con más goles es '%s'", equipo.getNombre()));
                    break;
                case 2:
                    equipo = equipos.equipoConMasPuntos();
                    System.out.println(String.format("El equipo con más puntos es '%s'", equipo.getNombre()));
                    break;
                case 3:
                    equipo = equipos.equipoConMasPartidosGanados();
                    System.out.println(String.format("El equipo con más partidos ganados es '%s'", equipo.getNombre()));
                    break;
                case 4:
                    int golesTotal = equipos.golesTotales();
                    System.out.println(String.format("El total de goles anotados es '%s'", golesTotal));
                    break;
                case 5:
                    int golesPromedio = equipos.promedioGoles();
                    System.out.println(String.format("El promedio de goles anotados es '%s'", golesPromedio));
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

    public static void main(String[] args) {

        Reporte equipos = new Reporte();
        ArrayList<Partido> partidos = new ArrayList<>();

        System.out.println("Bienvenido al sistema de administración de la liga BetPlay:");

        boolean flag = true;

        while (flag) {
            System.out.println(
                    "Ingrese alguna de las siguientes opciones:\n1.Registrar Equipo\n2.Registrar partido\n3.Reportes\n0.Salir");
            int opcion = -1;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
                continue;
            }

            switch (opcion) {
                case 1:
                    Equipo nuevoEquipo = registrarEquipo();
                    equipos.addEquipo(nuevoEquipo);
                    System.out.println(String.format("El equipo %s se agregó correctamente", nuevoEquipo.getNombre()));
                    break;
                case 2:
                    Partido nuevoPartido = registrarPartido(equipos.getListaEquipos());
                    if (nuevoPartido != null) {
                        partidos.add(nuevoPartido);
                        nuevoPartido.asignarPuntos();
                        System.out.println("Partido registrado correctamente.");
                    }
                    break;
                case 3:
                    menuReportes(equipos);
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
