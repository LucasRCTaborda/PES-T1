package com.PAS_T1.PAS.aplicacao.casosDeUso;

import com.PAS_T1.PAS.aplicacao.dtos.AplicativoDTO;
import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import com.PAS_T1.PAS.dominio.servicos.AplicativoService;

import java.util.List;

public class TodosOsAplicativos {
    private AplicativoService aplicativoService;


    public TodosOsAplicativos(AplicativoService aplicativoService){
        this.aplicativoService = aplicativoService;
    }

    public List<AplicativoDTO> run() {
        return aplicativoService.aplicativosCadastrados().stream()
                .map(p->AplicativoDTO.fromModel(p))
                .toList();

    }
}