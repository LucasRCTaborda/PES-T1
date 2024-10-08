package com.PAS_T1.PAS.infrastructure.persistence;


import java.util.List;
import java.util.Optional;

public interface AssinaturaJPA_itfRep {
    List<Assinatura> findAll();
    Optional<Assinatura> findById(long id);
}
