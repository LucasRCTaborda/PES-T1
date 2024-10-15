package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity;


import com.PAS_T1.PAS.dominio.modelos.UsuarioModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long codigo;
    private String usuario;
    private String senha;
    public Usuario() {
    }
    public Usuario(long id,String usuario, String senha) {
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

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public static Usuario fromUsuarioModel(UsuarioModel uModel){
        return new Usuario(uModel.getCodigo(),uModel.getUsuario(),uModel.getSenha());
    }

    public static UsuarioModel toUsuarioModel(Usuario usua){
        return new UsuarioModel(usua.getCodigo(),usua.getUsuario(),usua.getSenha());
    }
}
