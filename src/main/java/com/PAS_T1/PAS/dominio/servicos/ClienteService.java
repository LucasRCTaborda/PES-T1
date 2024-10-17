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
@Autowired
    private ClienteJpa_itfRep clienteJpaItfRep;


    public ClienteService(ClienteJpa_itfRep clienteJpaItfRep) {
        this.clienteJpaItfRep = clienteJpaItfRep;
    }

    public Cliente save(Cliente cliente) {
        return clienteJpaItfRep.save(cliente);
    }



    public void delete(Cliente cliente) {
        clienteJpaItfRep.delete(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteJpaItfRep.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteJpaItfRep.findById(id);
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        return save(cliente);
    }

    public Cliente editarCliente(Long id, Cliente clienteAtualizado) {
        Optional<Cliente> optionalCliente = buscarClientePorId(id);
        if (optionalCliente.isPresent()) {
            Cliente clienteExistente = optionalCliente.get();

            // Atualiza apenas os campos que foram fornecidos no clienteAtualizado (evita sobreescrever campos não alterados)
            if (clienteAtualizado.getNome() != null) {
                clienteExistente.setNome(clienteAtualizado.getNome());
            }
            if (clienteAtualizado.getEmail() != null) {
                clienteExistente.setEmail(clienteAtualizado.getEmail());
            }


            // Salva as alterações no clienteExistente
            return clienteJpaItfRep.save(clienteExistente);
        } else {
            // Lógica de tratamento de erro se o cliente não for encontrado
            throw new EntityNotFoundException("Cliente com ID " + id + " não encontrado.");
        }
    }

}
