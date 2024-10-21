package com.PAS_T1.PAS.interfaceAdaptadora.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assinaturas")
public class AssinaturaController {/*

    private final CriarAssinatura assinaturaService;
    private final AssinaturaJPA_itfRep assinaturaJPAItfRep;
    private final ClienteJPA_itfRep clienteJPAItfRep; // Repositório de cliente
    private final AplicativoJPA_itfRep aplicativoJPAItfRep; // Repositório de aplicativo

    public AssinaturaController(
            CriarAssinatura assinaturaService,
            AssinaturaJPA_itfRep assinaturaJPAItfRep,
            ClienteJPA_itfRep clienteJPAItfRep,
            AplicativoJPA_itfRep aplicativoJPAItfRep) {
        this.assinaturaService = assinaturaService;
        this.assinaturaJPAItfRep = assinaturaJPAItfRep;
        this.clienteJPAItfRep = clienteJPAItfRep;
        this.aplicativoJPAItfRep = aplicativoJPAItfRep;
    }

    @PostMapping
    public ResponseEntity<AssinaturaDTO> criarAssinatura(@RequestBody AssinaturaRequest request) {
        // Encontrar cliente e aplicativo usando os IDs do request
        Optional<ClienteModel> optionalCliente = clienteJPAItfRep.findById(request.getClienteId());
        Optional<AplicativoModel> optionalAplicativo = aplicativoJPAItfRep.findById(request.getAplicativoId());

        if (optionalCliente.isPresent() && optionalAplicativo.isPresent()) {
            ClienteModel cliente = optionalCliente.get();
            AplicativoModel aplicativo = optionalAplicativo.get();

            AssinaturaDTO assinaturaDTO = assinaturaService.criarAssinaturaComClienteEAplicativo(cliente, aplicativo);
            return ResponseEntity.ok(assinaturaDTO);
        } else {
            return ResponseEntity.badRequest().body(null); // Retorna 400 se o cliente ou aplicativo não for encontrado
        }
    }

    // Adicionando um método para buscar todas as assinaturas
    @GetMapping
    public ResponseEntity<List<AssinaturaDTO>> buscarTodasAssinaturas() {
        List<AssinaturaDTO> assinaturas = assinaturaJPAItfRep.findAll().stream()
                .map(AssinaturaDTO::fromModel) // Supondo que haja um método `fromModel` na DTO
                .collect(Collectors.toList());
        return ResponseEntity.ok(assinaturas);
    }

    // Adicionando um método para buscar uma assinatura específica por ID
    @GetMapping("/{id}")
    public ResponseEntity<AssinaturaDTO> buscarAssinaturaPorId(@PathVariable long id) {
        Optional<Assinatura> optionalAssinatura = assinaturaJPAItfRep.findById(id);
        if (optionalAssinatura.isPresent()) {
            AssinaturaDTO assinaturaDTO = AssinaturaDTO.fromModel(optionalAssinatura.get());
            return ResponseEntity.ok(assinaturaDTO);
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 se a assinatura não for encontrada
        }
    }
}

// Classe auxiliar para o Request
class AssinaturaRequest {
    private long clienteId;
    private long aplicativoId;

    // Getters e Setters
    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public long getAplicativoId() {
        return aplicativoId;
    }

    public void setAplicativoId(long aplicativoId) {
        this.aplicativoId = aplicativoId;
    }*/
}
