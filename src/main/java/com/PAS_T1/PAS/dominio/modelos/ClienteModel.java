package com.PAS_T1.PAS.dominio.modelos;

import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.ClienteRepJpa;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

public class ClienteModel {

    @Id
    @GeneratedValue
    private long codigo;
    private String nome;
    private String email;  // Corrigido para "email" em minúsculas

    // Construtor
    public ClienteModel(long codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;  // Corrigido para usar "this.email"
    }

    // Getters e Setters
    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;  // Corrigido para "email"
    }

    public void setEmail(String email) {
        this.email = email;  // Corrigido para "this.email"
    }

    // Acesso ao repositório deve ser feito em outro lugar (injetar o repositório em um serviço)
    // private final ClienteRepJpa clienteRepJpa = null;

    // Este método deve ser movido para o serviço que usa ClienteModel
    public ClienteModel encontrarCliente(long codigoCliente, ClienteRepJpa clienteRepJpa) {
        ClienteModel modelCliente = null;

        List<ClienteModel> todosClientes = clienteRepJpa.todos();
        for (ClienteModel umCliente : todosClientes) {
            if (umCliente.getCodigo() == codigoCliente) {
                modelCliente = umCliente;
                break;
            }
        }

        return modelCliente;
    }

    @Override
    public String toString() {
        return "ClienteModel{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +  // Corrigido para "email"
                '}';
    }
}
