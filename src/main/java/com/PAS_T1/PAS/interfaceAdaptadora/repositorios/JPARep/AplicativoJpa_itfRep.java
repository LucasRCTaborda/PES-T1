package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.JPARep;

import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Aplicativo;
import org.springframework.data.repository.CrudRepository;



import java.util.List;

public interface AplicativoJpa_itfRep extends CrudRepository<Aplicativo,Long> {
    List<Aplicativo> findAll();
    Aplicativo findById(long id);
}
