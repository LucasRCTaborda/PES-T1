package com.PAS_T1.PAS.interfaceAdaptadora.controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;

public interface AplicativoRepository extends JpaRepository<AplicativoModel, Long> {
}
