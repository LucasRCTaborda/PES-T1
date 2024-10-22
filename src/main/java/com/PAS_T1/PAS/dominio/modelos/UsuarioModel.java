package com.PAS_T1.PAS.dominio.modelos;

public class UsuarioModel {
    long id;
    String login;
    String password;

    public UsuarioModel(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
