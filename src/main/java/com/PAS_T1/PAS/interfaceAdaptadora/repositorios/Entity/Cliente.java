package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity;


import com.PAS_T1.PAS.dominio.modelos.ClienteModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    private long id;
    private String nome;
    private String email;

    protected Cliente() {
    }

    public Cliente(long id, String nome, String email) {
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

    public static ClienteModel toClienteModel(Cliente cliente) {
        return new ClienteModel(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }

    public static Cliente fromClienteModel(ClienteModel clienteModel) {
        return new Cliente(clienteModel.getId(), clienteModel.getNome(), clienteModel.getEmail());
    }
}