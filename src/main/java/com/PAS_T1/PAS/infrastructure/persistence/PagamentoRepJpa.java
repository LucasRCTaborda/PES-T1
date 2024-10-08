package com.PAS_T1.PAS.infrastructure.persistence;

import com.bcopstein.sistvendas.dominio.modelos.AssinaturaModel;
import com.bcopstein.sistvendas.dominio.modelos.PagamentoModel;
import com.bcopstein.sistvendas.dominio.persistencia.IPagamentoRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
@Primary
public class PagamentoRepJpa implements IPagamentoRepository {
private PagamentoJpa_itfRep pagamentoRepository;


public PagamentoRepJpa(PagamentoJpa_itfRep pagamentoRepository){
    this.pagamentoRepository=pagamentoRepository;
}
private IPagamentoRepository pagamentos;
    @Override
    public List<PagamentoModel> todos() {
        return pagamentos.todos();

    }

    @Override
    public PagamentoModel consultaPorId(Long codigo) {
        return null;
    }

    @Override
    public List<AssinaturaModel> todosAssinatura() {
        return null;
    }

    @Override
    public AssinaturaModel consultaPorIdAssinatura(Long codigo) {
        return null;
    }
}
