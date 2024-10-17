package com.PAS_T1.PAS.interfaceAdaptadora.controllers;


import com.PAS_T1.PAS.dominio.modelos.ClienteModel;
import com.PAS_T1.PAS.dominio.servicos.ClienteService;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Cliente;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.ClienteRepJpa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Get/servcad/clientes")
public record ClienteController(ClienteService clienteService, ClienteRepJpa clienteRepJpa) {


    @GetMapping("/todos")
    public List<ClienteModel> todosClientes() {
        return clienteRepJpa.todos();
    }


    @PostMapping("/cadastrar")
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        try {
            Cliente novoCliente = clienteService.cadastrarCliente(cliente);  // Chama o serviço para salvar o cliente
            return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);    // Retorna 201 (Created)
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);  // Em caso de erro, retorna 500
        }
    }



    // precisa atualizar porque estou usando o padrao
    @PutMapping("/editar/{id}")
    public ResponseEntity<Cliente> editarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        Cliente clienteEditado = clienteService.editarCliente(id, clienteAtualizado);
        if (clienteEditado != null) {
            return ResponseEntity.ok(clienteEditado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
        if (cliente.isPresent()) {
            clienteService.delete(cliente.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
