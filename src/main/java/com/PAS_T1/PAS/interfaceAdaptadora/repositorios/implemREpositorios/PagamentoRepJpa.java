package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios;

import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Assinatura;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface PagamentoRepJpa extends JpaRepository<Pagamento, Long> {
    Pagamento save(Pagamento pagamento);
    List<Pagamento> findByAssinatura(Assinatura Assinatura);
    List<Pagamento> findByDataPagamento(Date dataPagamento);
}
