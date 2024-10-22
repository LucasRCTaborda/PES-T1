package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios;


import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Aplicativo;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Assinatura;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssinaturaRepJpa extends JpaRepository<Assinatura, Long> {
    List<Assinatura> findByCliente(Cliente cliente);
    List<Assinatura> findByAplicativo(Aplicativo aplicativo);
    List<Assinatura> findByAplicativoId(Long id);
    List<Assinatura> findByClienteId(long id);
    Assinatura findById(long id);

    @Query("SELECT a FROM Assinatura a WHERE a.inicioVigencia < CURRENT_DATE AND a.fimVigencia > CURRENT_DATE")
    List<Assinatura> findActiveAssinaturas();

    @Query("SELECT a FROM Assinatura a WHERE a.inicioVigencia >= CURRENT_DATE OR a.fimVigencia <= CURRENT_DATE")
    List<Assinatura> findInactiveAssinaturas();

    @Query("SELECT MAX(a.id) FROM Assinatura a")
    Long findLastAssinaturaId();

    Assinatura save(Assinatura assinatura);
}
