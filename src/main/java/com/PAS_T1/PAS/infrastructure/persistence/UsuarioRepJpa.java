package com.PAS_T1.PAS.infrastructure.persistence;

import com.bcopstein.sistvendas.dominio.modelos.UsuarioModel;
import com.bcopstein.sistvendas.dominio.persistencia.IUsuarioRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
@Primary
public class UsuarioRepJpa implements IUsuarioRepository {
    private UsuarioJpa_itfRep usuarioRepository;

    public UsuarioRepJpa(UsuarioJpa_itfRep usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioModel> todos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.size() == 0) {
            return new LinkedList<>();
        } else {
            return usuarios.stream()
                    .map(usua -> Usuario.toUsuarioModel(usua))
                    .toList();
        }
    }

    public UsuarioModel consultaPorId(long id) {
        Usuario user = usuarioRepository.findById(id);
        System.out.println("Usuario de código: " + id + ": " + user);
        if (user == null) {
            return null;
        } else {
            return Usuario.toUsuarioModel(user);
        }
    }
}
