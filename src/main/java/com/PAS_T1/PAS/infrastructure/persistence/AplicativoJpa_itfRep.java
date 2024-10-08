package com.PAS_T1.PAS.infrastructure.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AplicativoJpa_itfRep extends CrudRepository<Aplicativo,Long> {
    List<Aplicativo> findAll();
    Optional<Aplicativo> findById(Long id);

    Aplicativo save(Aplicativo aplicativo);


}
