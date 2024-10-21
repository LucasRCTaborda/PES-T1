package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.JPARep;

import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Assinatura;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AssinaturaJPA_itfRep extends CrudRepository<Assinatura, Long> {
    // Aqui você pode adicionar métodos personalizados, se necessário
    List<Assinatura> findAll();
    Optional<Assinatura> findById(Long id);
}
