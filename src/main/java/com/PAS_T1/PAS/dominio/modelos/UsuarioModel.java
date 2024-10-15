package com.PAS_T1.PAS.dominio.modelos;


public class UsuarioModel {
    private long codigo;
    private String usuario;
    private String senha;

    public UsuarioModel(long id,String usuario, String senha) {
        this.codigo=id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "UsuarioModel{" +
                "codigo=" + codigo +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
