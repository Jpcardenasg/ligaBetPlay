package com.colfutbol;

import java.util.List;
import java.util.Scanner;

public class Partido {

    private String fechaPartido;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Integer golesEquipoLocal;
    private Integer golesEquipoVisitante;

    public Partido(String fechaPartido, Equipo equipoLocal, Equipo equipoVisitante, Integer golesEquipoLocal,
            Integer golesEquipoVisitante) {

        this.fechaPartido = fechaPartido;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    public void asignarPuntos() {

        if (this.golesEquipoLocal == this.golesEquipoVisitante) {
            this.equipoLocal.partidoEmpatado(golesEquipoLocal, golesEquipoVisitante);
            this.equipoVisitante.partidoEmpatado(golesEquipoVisitante, golesEquipoLocal);

        } else if (this.golesEquipoLocal > this.golesEquipoVisitante) {
            this.equipoLocal.partidoGanado(golesEquipoLocal, golesEquipoVisitante);
            this.equipoVisitante.partidoPerdido(golesEquipoVisitante, golesEquipoLocal);

        } else {
            this.equipoLocal.partidoPerdido(golesEquipoLocal, golesEquipoVisitante);
            this.equipoVisitante.partidoGanado(golesEquipoVisitante, golesEquipoLocal);
        }
    }

    public String getFechaPartido() {
        return fechaPartido;
    }

    public static Partido registrarPartido(List<Equipo> equipos) {
        Scanner sc = new Scanner(System.in);

        if (equipos.size() < 2) {
            System.out.println("Se necesitan al menos dos equipos registrados para registrar un partido.");
            sc.close();
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
        sc.close();
        return new Partido(fechaPartido, equipos.get(indexLocal), equipos.get(indexVisitante), golesLocal,
                golesVisitante);
    }
}
