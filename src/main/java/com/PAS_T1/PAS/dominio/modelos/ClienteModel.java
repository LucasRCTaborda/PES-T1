package com.PAS_T1.PAS.dominio.modelos;

public class ClienteModel {
    long id;
    String nome;
    String email;

    public ClienteModel(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
