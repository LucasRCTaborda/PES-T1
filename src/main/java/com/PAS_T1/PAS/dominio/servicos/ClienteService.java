package com.PAS_T1.PAS.dominio.servicos;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {


































/*
    private final IClienteRepository iClienteRepository;

    public ClienteService(IClienteRepository iClienteRepository) {
        this.iClienteRepository = iClienteRepository;
    }

    public Cliente save(Cliente cliente) {
        return iClienteRepository.save(cliente);
    }

    public void delete(Cliente cliente) {
        iClienteRepository.delete(cliente);
    }

    public List<Cliente> listarClientes() {
        return iClienteRepository.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return iClienteRepository.findById(id);
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        return save(cliente);
    }

    public Cliente editarCliente(Long id, Cliente clienteAtualizado) {
        Optional<Cliente> optionalCliente = buscarClientePorId(id);
        if (optionalCliente.isPresent()) {
            Cliente clienteExistente = optionalCliente.get();
            // Atualize os campos do clienteExistente com os valores de clienteAtualizado
            // Exemplo: clienteExistente.setNome(clienteAtualizado.getNome());
            return save(clienteExistente);
        } else {
            // Lógica de tratamento de erro se o cliente não for encontrado
            return null;
        }
    }*/
}
