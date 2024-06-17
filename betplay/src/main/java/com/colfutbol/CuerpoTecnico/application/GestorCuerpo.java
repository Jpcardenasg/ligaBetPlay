package com.colfutbol.CuerpoTecnico.application;

import java.util.ArrayList;
import java.util.List;

import com.colfutbol.CuerpoTecnico.domain.CuerpoTecnico;

public class GestorCuerpo {
    private List<CuerpoTecnico> cuerpoTecnico;

    public GestorCuerpo() {
        cuerpoTecnico = new ArrayList<>();
    }

    public void addCuerpoTecnico(CuerpoTecnico cTecnico) {
        cuerpoTecnico.add(cTecnico);
    }

    public List<CuerpoTecnico> getCuerpoTecnico() {
        return cuerpoTecnico;
    }

    public boolean existeCuerpoTecnico(int id) {
        for (CuerpoTecnico tecnico : cuerpoTecnico) {
            if (tecnico.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
