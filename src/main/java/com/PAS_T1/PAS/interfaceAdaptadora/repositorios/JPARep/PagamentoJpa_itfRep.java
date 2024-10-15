package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.JPARep;

import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Pagamento;
import org.springframework.data.repository.CrudRepository;



import java.util.List;
import java.util.Optional;

public interface PagamentoJpa_itfRep extends CrudRepository<Pagamento, Long> {

    List<Pagamento> findAll();
    Optional<Pagamento> findById(long id);
}
