package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.JPARep;

import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface UsuarioJpa_itfRep  extends CrudRepository<Usuario, Long> {
    List<Usuario> findAll();
    Usuario findById(long id);
}
