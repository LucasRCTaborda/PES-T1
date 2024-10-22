package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity;


import com.PAS_T1.PAS.dominio.modelos.UsuarioModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    private long id;
    private String login;
    private String password;

    protected Usuario(){}

    public Usuario(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static UsuarioModel toUsuarioModel(Usuario usuario){
        return new UsuarioModel(
                usuario.id,
                usuario.getLogin(),
                usuario.getPassword()
        );
    }

    public static Usuario fromUsuarioModel(UsuarioModel usuarioModel){
        return new Usuario(usuarioModel.getId(),
                     usuarioModel.getLogin(),
                         usuarioModel.getPassword());
    }
}
