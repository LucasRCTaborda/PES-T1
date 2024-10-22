package com.PAS_T1.PAS.dominio.interRepositorios;


import com.PAS_T1.PAS.dominio.modelos.AssinaturaModel;
import com.PAS_T1.PAS.dominio.modelos.PagamentoModel;

import java.util.Date;
import java.util.List;

public interface IPagamentoRepository {
    PagamentoModel save(PagamentoModel pagamento);
    List<PagamentoModel> findByAssinatura(AssinaturaModel Assinatura);
    List<PagamentoModel> findByDataPagamento(Date dataPagamento);
}
