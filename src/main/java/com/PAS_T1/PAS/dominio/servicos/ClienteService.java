package com.PAS_T1.PAS.dominio.servicos;

import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Cliente;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.JPARep.ClienteJpa_itfRep;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepositoryImpl clienteRepositoryImpl;

    @Autowired
    public ClienteService(ClienteRepositoryImpl clienteRepositoryImpl) {
        this.clienteRepositoryImpl = clienteRepositoryImpl;
    }

    public List<ClienteModel> findAll() {
        return clienteRepositoryImpl.findAll();
    }

}