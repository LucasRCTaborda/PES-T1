package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.JPARep;



import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Assinatura;

import java.util.List;
import java.util.Optional;

public interface AssinaturaJPA_itfRep {
    List<Assinatura> findAll();
    Optional<Assinatura> findById(long id);
}
