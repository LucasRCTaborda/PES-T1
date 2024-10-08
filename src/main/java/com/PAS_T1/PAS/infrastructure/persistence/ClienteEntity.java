package com.PAS_T1.PAS.infrastructure.persistence;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ClienteEntity {


    @Id
    @GeneratedValue
    private long ID;
    private String nome;
    private String Email;

    public ClienteEntity() {
    }

    public ClienteEntity(long ID, String nome, String email) {
        this.ID = ID;
        this.nome = nome;
        Email = email;
    }

    public long getcodigo() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


}
