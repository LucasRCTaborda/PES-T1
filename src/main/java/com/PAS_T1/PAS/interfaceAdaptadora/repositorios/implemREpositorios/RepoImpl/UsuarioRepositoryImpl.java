package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.RepoImpl;

import com.PAS_T1.PAS.dominio.interRepositorios.IUsuarioRepository;
import com.PAS_T1.PAS.dominio.modelos.UsuarioModel;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Usuario;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.UsuarioRepJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements IUsuarioRepository {
    private UsuarioRepJpa usuarioRepositoryJpa;

    @Autowired
    public UsuarioRepositoryImpl(UsuarioRepJpa usuarioRepositoryJpa) {
        this.usuarioRepositoryJpa = usuarioRepositoryJpa;
    }

    @Override
    public List<UsuarioModel> findByLogin(String login) {
        return usuarioRepositoryJpa.findByLogin(login).stream().map(Usuario::toUsuarioModel).toList();
    }
}
