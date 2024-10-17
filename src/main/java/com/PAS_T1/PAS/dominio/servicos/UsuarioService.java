package com.PAS_T1.PAS.dominio.servicos;


import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Usuario;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.JPARep.UsuarioJpa_itfRep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record UsuarioService(UsuarioJpa_itfRep usuarioRepository) {


    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return save(usuario);
    }

    public Usuario editarUsuario(Long id, Usuario usuarioAtualizado) {
        Optional<Usuario> optionalUsuario = buscarUsuarioPorId(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuarioExistente = optionalUsuario.get();
            usuarioExistente.setUsuario(usuarioAtualizado.getUsuario());
            usuarioExistente.setSenha(usuarioAtualizado.getSenha());
            // Continue atualizando outros campos conforme necessário
            return save(usuarioExistente);
        } else {
            // Lógica de tratamento de erro se o usuário não for encontrado
            return null;
        }
    }
}