package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios;

import com.PAS_T1.PAS.dominio.interRepositorios.IClienteRepository;
import com.PAS_T1.PAS.dominio.modelos.ClienteModel;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Cliente;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.JPARep.ClienteJpa_itfRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClienteRepJpa implements IClienteRepository {
    private final ClienteJpa_itfRep clienteRepository;

    @Autowired
    public ClienteRepJpa(ClienteJpa_itfRep clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteModel> todos() {
        List<Cliente> clientes = clienteRepository.findAll();
        if (clientes.size() == 0){
            return new LinkedList<ClienteModel>();
        } else {
            return clientes.stream()
                    .map(clie -> Cliente.toClienteModel(clie))
                    .toList();
        }
    }

    @Override
    public ClienteModel consultaPorId(Long codigo) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(codigo);

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            System.out.println("Cliente de código: " + codigo + ": " + cliente);
            return Cliente.toClienteModel(cliente);
        } else {
            return null;
        }
    }

}
