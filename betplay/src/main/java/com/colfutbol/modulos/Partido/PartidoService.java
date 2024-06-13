package com.colfutbol.modulos.Partido;

import java.util.List;
import java.util.Scanner;

import com.colfutbol.modulos.Equipo.Equipo;
import com.colfutbol.modulos.Gestor.GestorListas;
import com.colfutbol.modulos.Jugador.Jugador;

public class PartidoService {

    public static Partido registrarPartido(GestorListas gestor) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        List<Equipo> equipos = gestor.getEquipos();

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

        // EQUIPO LOCAL

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

        int indexJugadorLocal = -1;
        int indexJugadorVisitante = -1;
        int golesJugador = -1;
        int golesLocal = 0;
        int golesVisitante = 0;

        System.out.println("Goles del equipo local.");
        System.out.println("Escoja el jugador para asignar la cantidad de goles que anotó (0. Salir):");

        List<Jugador> jugadoresEquipoLocal = equipos.get(indexLocal).getJugadores();

        boolean flag = true;

        while (flag) {
            for (int i = 0; i < jugadoresEquipoLocal.size(); i++) {
                System.out.println((i + 1) + ". " + jugadoresEquipoLocal.get(i).getNombre());
            }

            while (true) {
                try {
                    indexJugadorLocal = Integer.parseInt(sc.nextLine()) - 1;
                    if (indexJugadorLocal > 0 && indexJugadorLocal < jugadoresEquipoLocal.size()) {
                        break;
                    } else if (indexJugadorLocal == 0) {
                        flag = false;
                    } else {
                        System.out.println("Índice no válido. Intente nuevamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Intente nuevamente.");
                }
            }

            System.out.printf("Ingrese la cantidad de goles antodados por el jugador %s",
                    jugadoresEquipoLocal.get(indexJugadorLocal).getNombre());

            while (true) {
                try {
                    golesJugador = Integer.parseInt(sc.nextLine());
                    golesLocal += golesJugador;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Intente nuevamente.");
                }
            }

            jugadoresEquipoLocal.get(indexJugadorLocal).setGolesAnotados(golesJugador);
        }

        // EQUIPO VISITANTE

        System.out.println("Seleccione el equipo visitante:");
        for (int i = 0; i < equipos.size(); i++) {
            if (i != indexLocal) {
                System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
            }
        }

        while (true) {
            try {
                indexVisitante = Integer.parseInt(sc.nextLine()) - 1;
                if (indexVisitante >= 0 && indexVisitante < equipos.size()
                        && indexVisitante != indexLocal) {
                    break;
                } else {
                    System.out.println("Índice no válido o el mismo equipo que el local. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
            }
        }

        System.out.println("Goles del equipo visitante.");
        System.out.println("Escoja el jugador para asignar la cantidad de goles que anotó (0. Salir):");

        List<Jugador> jugadoresEquipoVisitante = equipos.get(indexVisitante).getJugadores();

        while (flag) {
            for (int i = 0; i < jugadoresEquipoVisitante.size(); i++) {
                System.out.println((i + 1) + ". " + jugadoresEquipoVisitante.get(i).getNombre());

            }

            while (true) {
                try {
                    indexJugadorVisitante = Integer.parseInt(sc.nextLine()) - 1;
                    if (indexJugadorVisitante > 0 && indexJugadorVisitante < jugadoresEquipoVisitante.size()) {
                        break;
                    } else if (indexJugadorVisitante == 0) {
                        flag = false;
                    } else {
                        System.out.println("Índice no válido. Intente nuevamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Intente nuevamente.");
                }
            }

            System.out.printf("Ingrese la cantidad de goles antodados por el jugador %s",
                    jugadoresEquipoVisitante.get(indexJugadorVisitante).getNombre());

            while (true) {
                try {
                    golesJugador = Integer.parseInt(sc.nextLine());
                    golesVisitante += golesJugador;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Intente nuevamente.");
                }
            }

            jugadoresEquipoVisitante.get(indexJugadorVisitante).setGolesAnotados(golesJugador);
        }

        return new Partido(fechaPartido, equipos.get(indexLocal), equipos.get(indexVisitante),
                golesLocal,
                golesVisitante);
    }
}
