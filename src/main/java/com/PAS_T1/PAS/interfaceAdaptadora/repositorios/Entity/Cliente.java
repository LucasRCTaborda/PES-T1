package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity;


import com.PAS_T1.PAS.dominio.modelos.ClienteModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cliente {


    @Id
    @GeneratedValue
    private long codigo;
    private String nome;
    private String Email;

    public Cliente() {
    }

    public Cliente(long codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        Email = email;
    }

    public long getcodigo() {
        return codigo;
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

    public static Cliente fromClienteModel(ClienteModel cModel){
        return new Cliente(cModel.getcodigo(),cModel.getNome(),cModel.getEmail());
    }

    public static ClienteModel toClienteModel(Cliente cli){
        return new ClienteModel(cli.getcodigo(),cli.getNome(),cli.getEmail());
    }
}
