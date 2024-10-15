package com.PAS_T1.PAS.dominio.interRepositorios;


import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import com.PAS_T1.PAS.dominio.modelos.AssinaturaModel;
import com.PAS_T1.PAS.dominio.modelos.ClienteModel;

import java.util.List;
import java.util.Optional;

public interface IAssinaturaRepository  {
    List<AssinaturaModel> todosAssinatura ();
    List<AplicativoModel> todosAplicativos();
    List<ClienteModel> todosClientes();

    Optional<AssinaturaModel> consultaPorId(Long codigo);
    AssinaturaModel ConsultaporIdAssinatura(long codigo);
}
