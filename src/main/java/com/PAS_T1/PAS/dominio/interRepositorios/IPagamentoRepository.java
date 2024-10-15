package com.PAS_T1.PAS.dominio.interRepositorios;


import com.PAS_T1.PAS.dominio.modelos.AssinaturaModel;
import com.PAS_T1.PAS.dominio.modelos.PagamentoModel;

import java.util.List;

public interface IPagamentoRepository {
    List<PagamentoModel> todos ();
    PagamentoModel consultaPorId(Long codigo);


    List<AssinaturaModel> todosAssinatura ();
    AssinaturaModel consultaPorIdAssinatura(Long codigo);

}
