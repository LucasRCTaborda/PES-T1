package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios;


import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepJpa extends JpaRepository<Usuario, Long> {
    List<Usuario> findByLogin(String login);
}
