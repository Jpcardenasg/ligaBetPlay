package com.colfutbol;

import java.util.List;
import java.util.Scanner;

import com.colfutbol.CuerpoTecnico.application.RegistroService;
import com.colfutbol.CuerpoTecnico.domain.CuerpoTecnico;
import com.colfutbol.Equipo.application.EquipoService;
import com.colfutbol.Equipo.domain.Equipo;
import com.colfutbol.Jugador.application.JugadorService;
import com.colfutbol.Jugador.domain.Jugador;
import com.colfutbol.Partido.application.PartidoService;
import com.colfutbol.Partido.domain.Partido;
import com.colfutbol.modulos.Gestor.GestorListas;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void menuReportes(GestorListas gestor) {
        boolean flag = true;

        while (flag) {
            System.out.println(
                    "Ingrese alguna de las siguientes opciones:\n1.Equipo con más goles anotados\n2.Equipo con más puntos\n3.Equipo con más partidos ganados\n4.Total goles anotados\n5.Promedio goles anotados\n6.Tabla de posiciones\n0.Salir");
            int opcion = -1;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
                continue;
            }

            switch (opcion) {
                case 1:
                    Equipo equipoConMasGoles = gestor.equipoConMasGoles();
                    if (equipoConMasGoles != null) {
                        System.out.println(
                                String.format("El equipo con más goles es '%s'", equipoConMasGoles.getNombre()));
                    } else {
                        System.out.println("No hay equipos registrados.");
                    }
                    break;
                case 2:
                    Equipo equipoConMasPuntos = gestor.equipoConMasPuntos();
                    if (equipoConMasPuntos != null) {
                        System.out.println(
                                String.format("El equipo con más puntos es '%s'", equipoConMasPuntos.getNombre()));
                    } else {
                        System.out.println("No hay equipos registrados.");
                    }
                    break;
                case 3:
                    Equipo equipoConMasPartidosGanados = gestor.equipoConMasPartidosGanados();
                    if (equipoConMasPartidosGanados != null) {
                        System.out.println(
                                String.format("El equipo con más partidos ganados es '%s'",
                                        equipoConMasPartidosGanados.getNombre()));
                    } else {
                        System.out.println("No hay equipos registrados.");
                    }
                    break;
                case 4:
                    int golesTotal = gestor.golesTotales();
                    System.out.println(String.format("El total de goles anotados es '%s'", golesTotal));
                    break;
                case 5:
                    int golesPromedio = gestor.promedioGoles();
                    System.out.println(String.format("El promedio de goles anotados es '%s'", golesPromedio));
                    break;
                case 6:
                    List<Equipo> tablaPosiciones = gestor.tablaDePosiciones();
                    if (tablaPosiciones != null && !tablaPosiciones.isEmpty()) {
                        System.out.println("Tabla de posiciones:");
                        for (int i = 0; i < tablaPosiciones.size(); i++) {
                            Equipo equipo = tablaPosiciones.get(i);
                            System.out.println(
                                    (i + 1) + ". " + equipo.getNombre() + " - " + equipo.getPuntos() + " puntos");
                        }
                    } else {
                        System.out.println("No hay equipos registrados.");
                    }
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
                    "Ingrese alguna de las siguientes opciones:\n1.Registrar Equipo\n2.Registrar partido\n3.Registrar jugador\n4.Registrar profesional de cuerpo técnico\n0.Salir");
            int opcion = -1;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
                continue;
            }

            switch (opcion) {
                case 1:
                    Equipo nuevoEquipo = EquipoService.registrarEquipo(sc);
                    gestor.addEquipo(nuevoEquipo);
                    System.out.println(String.format("El equipo %s se agregó correctamente", nuevoEquipo.getNombre()));
                    break;
                case 2:
                    Partido nuevoPartido = PartidoService.registrarPartido(gestor);
                    if (nuevoPartido != null) {
                        gestor.addPartido(nuevoPartido);
                        nuevoPartido.asignarPuntos();
                        System.out.println("Partido registrado correctamente.");
                    }
                    break;
                case 3:
                    Jugador nuevoJugador = JugadorService.registrarJugador(sc, gestor);
                    if (nuevoJugador != null) {
                        gestor.addJugador(nuevoJugador);
                        System.out.println(
                                String.format("El jugador '%s' ha sido registrado", nuevoJugador.getNombre()));
                    }
                    break;
                case 4:
                    CuerpoTecnico nuevoTecnico = RegistroService.registrarCuerpoTecnico(sc, gestor);
                    if (nuevoTecnico != null) {
                        gestor.addCuerpoTecnico(nuevoTecnico);
                        System.out.println(String.format("El profesional del cuerpo técnico '%s' ha sido registrado",
                                nuevoTecnico.getNombre()));
                    }
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

        GestorListas listas = new GestorListas();

        boolean flag = true;

        while (flag) {
            System.out.println("Ingrese alguna de las siguientes opciones:\n1.Registros\n2.Reportes\n0.Salir");
            int opcion = -1;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
                continue;
            }

            switch (opcion) {
                case 1:
                    registros(listas);
                    break;
                case 2:
                    menuReportes(listas);
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
