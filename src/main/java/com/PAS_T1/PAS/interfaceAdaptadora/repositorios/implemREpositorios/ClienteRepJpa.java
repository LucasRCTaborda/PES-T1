package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios;

import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepJpa extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNome(String nome);
    Cliente findByEmail(String email);
    List<Cliente> findAll();
    Cliente findById(long id);
}
