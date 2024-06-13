package com.colfutbol.modulos.Cuerpo;

import com.colfutbol.modulos.Persona.Persona;

public class CuerpoTecnico extends Persona {

    private String rol;
    private String licencia;
    private int experiencia;

    public CuerpoTecnico() {
    }

    public CuerpoTecnico(int id, String nombre, String apellidos, int edad, String nacionalidad, String rol,
            String licencia, int experiencia) {
        super(id, nombre, apellidos, edad, nacionalidad);
        this.rol = rol;
        this.licencia = licencia;
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "CuerpoTecnico{" +
                "rol='" + rol + '\'' +
                ", licencia='" + licencia + '\'' +
                ", añosExperiencia=" + experiencia +
                '}';
    }
}
