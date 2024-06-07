package com.colfutbol;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void menuReportes(GestorListas equipos) {
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

    public static void registros(GestorListas gestor) {
        boolean flag = true;

        while (flag) {
            System.out.println(
                    "Ingrese alguna de las siguientes opciones:\n1.Registrar Equipo\n2.Registrar partido\n3.Registrar jugador\n4.Registrar profesional de cuerpo técnico\n5.Registrar profesional de cuerpo médico\n0.Salir");
            int opcion = -1;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
                continue;
            }

            switch (opcion) {
                case 1:
                    Equipo nuevoEquipo = Equipo.registrarEquipo(sc);
                    gestor.addEquipo(nuevoEquipo);
                    System.out.println(String.format("El equipo %s se agregó correctamente", nuevoEquipo.getNombre()));
                    break;
                case 2:
                    Partido nuevoPartido = Partido.registrarPartido(gestor.getEquipos());
                    if (nuevoPartido != null) {
                        gestor.addPartido(nuevoPartido);
                        nuevoPartido.asignarPuntos();
                        System.out.println("Partido registrado correctamente.");
                    }
                    break;
                case 3:
                    Jugador nuevoJugador = Jugador.registrarJugador(sc, gestor);
                    gestor.addJugador(nuevoJugador);
                    System.out.println(String.format("El jugador '%s' ha sido registrado", nuevoJugador.getNombre()));
                    break;
                case 4:
                    // registrar profesional de cuerpo técnico
                    break;
                case 5:
                    // registrar profesional de cuerpo médico
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

        System.out.println("Bienvenido al sistema de administración de la liga BetPlay:");

        GestorListas gestor = new GestorListas();

        boolean flag = true;

        while (flag) {
            System.out.println("Ingrese alguna de las siguientes opciones:\n1.Registros\n2.Reportes\n0.Salir");
            int opcion = -1;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Intente nuevamente.");
                continue;
            }

            switch (opcion) {
                case 1:
                    registros(gestor);
                    break;
                case 2:
                    menuReportes(gestor);
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
