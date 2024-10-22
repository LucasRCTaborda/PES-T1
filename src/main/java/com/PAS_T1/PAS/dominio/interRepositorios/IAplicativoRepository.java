package com.PAS_T1.PAS.dominio.interRepositorios;


import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;

import java.util.List;

public interface IAplicativoRepository {
    List<AplicativoModel> findAll();
    AplicativoModel findById(long id);
    List<AplicativoModel> findByNome(String nome);
    List<AplicativoModel> findByCustoMensal(double custoMensal);
    AplicativoModel save(AplicativoModel aplicativo);
}

