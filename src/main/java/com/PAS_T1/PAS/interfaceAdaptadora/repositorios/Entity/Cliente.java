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
    private String email;

    public Cliente(long codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;  // Corrigido para usar o "this.email"
    }

    public Cliente() {

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
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }

    public static Cliente fromClienteModel(ClienteModel cModel) {
        return new Cliente(cModel.getCodigo(), cModel.getNome(), cModel.getEmail());
    }

    public static ClienteModel toClienteModel(Cliente cli) {
        return new ClienteModel(cli.getcodigo(), cli.getNome(), cli.getEmail());
    }
}
