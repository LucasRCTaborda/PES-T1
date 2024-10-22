package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.RepoImpl;

import com.PAS_T1.PAS.dominio.interRepositorios.IPagamentoRepository;
import com.PAS_T1.PAS.dominio.modelos.AssinaturaModel;
import com.PAS_T1.PAS.dominio.modelos.PagamentoModel;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Assinatura;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Pagamento;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.AplicativoRepJpa;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.PagamentoRepJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class PagamentoRepositoryImpl implements IPagamentoRepository {

    private final AplicativoRepJpa aplicativoRepositoryJpa;
    private PagamentoRepJpa pagamentoRepositoryJpa;

    @Autowired
    public PagamentoRepositoryImpl(PagamentoRepJpa pagamentoRepositoryJpa, AplicativoRepJpa aplicativoRepositoryJpa) {
        this.pagamentoRepositoryJpa = pagamentoRepositoryJpa;
        this.aplicativoRepositoryJpa = aplicativoRepositoryJpa;
    }

    @Override
    public PagamentoModel save(PagamentoModel pagamento) {
        return Pagamento.toPagamentoModel(pagamentoRepositoryJpa.save(Pagamento.fromPagamentomodel(pagamento)));
    }

    @Override
    public List<PagamentoModel> findByAssinatura(AssinaturaModel assinatura) {
        return pagamentoRepositoryJpa.findByAssinatura(Assinatura.fromAssinaturaModel(assinatura)).stream().map(Pagamento::toPagamentoModel).toList();
    }

    @Override
    public List<PagamentoModel> findByDataPagamento(Date dataPagamento) {
        return pagamentoRepositoryJpa.findByDataPagamento(dataPagamento).stream().map(Pagamento::toPagamentoModel).toList();
    }
}
