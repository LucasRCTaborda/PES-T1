package com.PAS_T1.PAS.interfaceAdaptadora.controllers;


import com.PAS_T1.PAS.dominio.modelos.UsuarioModel;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.UsuarioRepJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


@Autowired
    private final UsuarioRepJpa usuarioService;

    @Autowired
    public UsuarioController(UsuarioRepJpa usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping("/cadastrar/{usuario}/{senha}")
    public List<UsuarioModel> cadastrarUsuario() {
  List<UsuarioModel> us=  usuarioService.todos();
  return us;
    }
    /*



    @PostMapping("/cadastrar/{usuario}/{senha}")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody String usuario, @PathVariable String senha) {
        Usuario novoUsuario = new Usuario(usuario, senha);
        usuarioService.cadastrarUsuario(novoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @PutMapping("/editar/{id}/{usuario}/{senha}\"")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable Long id,@RequestBody String usuario, @PathVariable String senha) {
        Usuario usuarioAtualizado = new Usuario(usuario, senha);
       usuarioService.editarUsuario(id, usuarioAtualizado);
        if (usuarioAtualizado != null) {
            return ResponseEntity.ok(usuarioAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(id);
        if (usuario.isPresent()) {
            usuarioService.delete(usuario.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}
