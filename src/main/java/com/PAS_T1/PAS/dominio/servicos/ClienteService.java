package com.PAS_T1.PAS.dominio.servicos;

import com.PAS_T1.PAS.dominio.modelos.ClienteModel;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.RepoImpl.ClienteRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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