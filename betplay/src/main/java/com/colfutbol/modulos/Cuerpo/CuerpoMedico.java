package com.colfutbol.modulos.Cuerpo;

import com.colfutbol.modulos.Persona.Persona;

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

    @Override
    public String toString() {
        return "CuerpoMedico{" +
                "rol='" + rol + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", añosExperiencia=" + experiencia +
                '}';
    }
}
