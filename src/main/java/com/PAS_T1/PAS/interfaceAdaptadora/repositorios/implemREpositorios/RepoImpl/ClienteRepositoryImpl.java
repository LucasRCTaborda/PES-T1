package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.RepoImpl;

import com.PAS_T1.PAS.dominio.interRepositorios.IClienteRepository;
import com.PAS_T1.PAS.dominio.modelos.ClienteModel;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Cliente;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.ClienteRepJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepositoryImpl implements IClienteRepository {

    private ClienteRepJpa clienteRepositoryJpa;

    @Autowired
    public ClienteRepositoryImpl(ClienteRepJpa clienteRepositoryJpa) {
        this.clienteRepositoryJpa = clienteRepositoryJpa;
    }

    @Override
    public List<ClienteModel> findByNome(String nome) {
        return clienteRepositoryJpa.findByNome(nome).stream().map(Cliente::toClienteModel).toList();
    }

    @Override
    public ClienteModel findByEmail(String email) {
        return Cliente.toClienteModel(clienteRepositoryJpa.findByEmail(email));
    }

    @Override
    public List<ClienteModel> findAll() {
        return clienteRepositoryJpa.findAll().stream().map(Cliente::toClienteModel).toList();
    }

    @Override
    public ClienteModel findById(long id) {
        return Cliente.toClienteModel(clienteRepositoryJpa.findById(id));
    }
}
