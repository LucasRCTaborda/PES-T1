package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios;

import com.PAS_T1.PAS.dominio.interRepositorios.IPagamentoRepository;
import com.PAS_T1.PAS.dominio.modelos.AssinaturaModel;
import com.PAS_T1.PAS.dominio.modelos.PagamentoModel;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Pagamento;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.JPARep.PagamentoJpa_itfRep;
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

    @Override
    public List<PagamentoModel> todos() {
        List<Pagamento> pagamentos = pagamentoRepository.findAll();
        if (pagamentos.size() == 0) {
            return new LinkedList<PagamentoModel>();
        } else {
            return pagamentos.stream()
                    .map(prod -> Pagamento.toPagamentoModel(prod))
                    .toList();
        }
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
