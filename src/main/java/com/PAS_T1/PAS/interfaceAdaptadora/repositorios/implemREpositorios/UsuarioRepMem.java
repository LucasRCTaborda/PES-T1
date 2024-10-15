package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios;

import com.PAS_T1.PAS.dominio.interRepositorios.IUsuarioRepository;
import com.PAS_T1.PAS.dominio.modelos.UsuarioModel;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
@Repository

public class UsuarioRepMem implements IUsuarioRepository {
    private List<UsuarioModel> usuarios;
    public UsuarioRepMem(){
        usuarios = new LinkedList<>();
        usuarios.add(new UsuarioModel(1, "João", "12345"));
        usuarios.add(new UsuarioModel(2, "Maria", "abcde"));
        usuarios.add(new UsuarioModel(3, "Pedro", "fghij"));
        usuarios.add(new UsuarioModel(4, "Ana", "qwerty"));
        usuarios.add(new UsuarioModel(5, "Lucas", "zxcvb"));
        usuarios.add(new UsuarioModel(6, "Julia", "09876"));
        usuarios.add(new UsuarioModel(7, "Mateus", "poiuy"));
        usuarios.add(new UsuarioModel(8, "Carla", "mnbvc"));
        usuarios.add(new UsuarioModel(9, "Fernanda", "lkjhg"));
        usuarios.add(new UsuarioModel(10, "Rafael", "98765"));
    }
    @Override
    public List<UsuarioModel> todos() {
       return usuarios;
    }

    @Override
    public UsuarioModel consultaPorId(long codigo) {
       return usuarios.stream()
               .filter(p->p.getCodigo() == codigo)
               .findFirst()
               .orElse(null);
    }
}
