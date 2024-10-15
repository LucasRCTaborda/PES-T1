package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.JPARep;

import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Cliente;
import org.springframework.data.repository.CrudRepository;



import java.util.List;

public interface ClienteJpa_itfRep extends CrudRepository<Cliente,Long> {
    List<Cliente> findAll();
    Cliente findById(long id);
}
