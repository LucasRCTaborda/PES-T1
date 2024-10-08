package com.PAS_T1.PAS.application.usecases;

import com.bcopstein.sistvendas.aplicacao.dtos.UsuarioTDO;

import com.bcopstein.sistvendas.persistencia.UsuarioJpa_itfRep;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public record BuscaUsuarariosUC(UsuarioJpa_itfRep usuarioJpaItfRep) {


    public List<UsuarioTDO> run(){
        return usuarioJpaItfRep.findAll().stream()
                .map(p->UsuarioTDO.fromModel(p))
                .toList();
    }
}
