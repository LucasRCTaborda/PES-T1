package com.PAS_T1.PAS.aplicacao.dtos;




import com.PAS_T1.PAS.dominio.modelos.UsuarioModel;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

public class UsuarioTDO {
    @Id
    @GeneratedValue
    private Long codigo;
    private String usuario;
    private String senha;

    public UsuarioTDO(long id ,String usuario, String senha) {
        this.codigo=id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public static UsuarioTDO fromModel(UsuarioModel usuario){
        return new UsuarioTDO(usuario.getCodigo(), usuario.getUsuario(), usuario.getSenha());
    }
}
