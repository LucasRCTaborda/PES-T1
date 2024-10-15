package com.PAS_T1.PAS.dominio.servicos;


import com.PAS_T1.PAS.dominio.interRepositorios.IUsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public record UsuarioService(IUsuarioRepository iUsuarioRepository) {












































/*

    public Usuario save(Usuario usuario) {
        return iUsuarioRepository.save(usuario);
    }

    public void delete(Usuario usuario) {
        iUsuarioRepository.delete(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return iUsuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return iUsuarioRepository.findById(id);
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
    }*/
}