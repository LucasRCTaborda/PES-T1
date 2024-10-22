package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios;


import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Aplicativo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AplicativoRepJpa extends JpaRepository<Aplicativo, Long> {
        List<Aplicativo> findAll();
        Aplicativo findById(long id);
        List<Aplicativo> findByNome(String nome);
        List<Aplicativo> findByCustoMensal(double custoMensal);
        Aplicativo save(Aplicativo aplicativo);
    }
