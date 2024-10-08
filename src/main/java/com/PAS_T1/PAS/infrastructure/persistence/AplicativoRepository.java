package com.PAS_T1.PAS.infrastructure.persistence;

import com.PAS_T1.PAS.domain.entity.Aplicativo;
import org.springframework.data.repository.CrudRepository;

public interface AplicativoRepository extends CrudRepository<AplicativoEntity, Long> {
}
