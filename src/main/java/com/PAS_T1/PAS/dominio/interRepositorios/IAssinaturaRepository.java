package com.PAS_T1.PAS.dominio.interRepositorios;


import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import com.PAS_T1.PAS.dominio.modelos.AssinaturaModel;
import com.PAS_T1.PAS.dominio.modelos.ClienteModel;

import java.util.List;

public interface IAssinaturaRepository {
    List<AssinaturaModel> findAll();
    List<AssinaturaModel> findByCliente(ClienteModel cliente);
    List<AssinaturaModel> findByAplicativo(AplicativoModel aplicativo);
    List<AssinaturaModel> findByAplicativoId(Long id);
    List<AssinaturaModel> findByClienteId(long id);
    AssinaturaModel findById(long id);

    List<AssinaturaModel> findActiveAssinaturas();

    List<AssinaturaModel> findInactiveAssinaturas();

    Long findLastAssinaturaId();

    AssinaturaModel save(AssinaturaModel assinatura);
}
