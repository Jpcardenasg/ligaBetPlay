package com.colfutbol.CuerpoTecnico.domain;

import com.colfutbol.Persona.Persona;

public class CuerpoTecnico extends Persona {

    private String rol;
    private String especialidad;
    private int experiencia;

    public CuerpoTecnico() {
    }

    public CuerpoTecnico(int id, String nombre, String apellidos, int edad, String nacionalidad, String rol,
            String especialidad, int experiencia) {
        super(id, nombre, apellidos, edad, nacionalidad);
        this.rol = rol;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
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
