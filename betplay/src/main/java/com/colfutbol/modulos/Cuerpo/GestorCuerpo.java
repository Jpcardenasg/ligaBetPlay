package com.colfutbol.modulos.Cuerpo;

import java.util.ArrayList;
import java.util.List;

public class GestorCuerpo {
    private List<CuerpoMedico> cuerpoMedico;
    private List<CuerpoTecnico> cuerpoTecnico;

    public GestorCuerpo() {
        cuerpoMedico = new ArrayList<>();
        cuerpoTecnico = new ArrayList<>();
    }

    public void addCuerpoMedico(CuerpoMedico cMedico) {
        cuerpoMedico.add(cMedico);
    }

    public void addCuerpoTecnico(CuerpoTecnico cTecnico) {
        cuerpoTecnico.add(cTecnico);
    }

    public List<CuerpoMedico> getCuerpoMedico() {
        return cuerpoMedico;
    }

    public List<CuerpoTecnico> getCuerpoTecnico() {
        return cuerpoTecnico;
    }

    public boolean existeCuerpoMedico(int id) {
        for (CuerpoMedico medico : cuerpoMedico) {
            if (medico.getId() == id) {
                return true;
            }
        }
        return false;
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
