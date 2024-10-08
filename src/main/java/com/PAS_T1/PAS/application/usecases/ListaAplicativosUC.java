package com.PAS_T1.PAS.application.usecases;

import com.bcopstein.sistvendas.aplicacao.dtos.AplicativoTDO;
import com.bcopstein.sistvendas.persistencia.AplicativoJpa_itfRep;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public record ListaAplicativosUC(AplicativoJpa_itfRep aplicativoJpaItfRep){
    public List<AplicativoTDO> run(){
        return aplicativoJpaItfRep.findAll().stream()
                .map(p-> AplicativoTDO.fromModel(p))
                .toList();
    }

}
