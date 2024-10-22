package com.PAS_T1.PAS.interfaceAdaptadora.controllers;

import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import com.PAS_T1.PAS.dominio.servicos.AplicativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("servcad/aplicativos")
public class AplicativoController {

    private AplicativoService aplicativoService;

    @Autowired
    public AplicativoController(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    @GetMapping
    public List<AplicativoModel> getAll() {
        return aplicativoService.findAll();
    }

    @PostMapping("/atualizacusto/{idAplicativo}")
    public ResponseEntity<AplicativoModel> atualizarCusto(@PathVariable Long idAplicativo, @RequestBody Double custo) {
        AplicativoModel aplicativo = aplicativoService.atualizaCustoMensal(idAplicativo, custo);
        if (aplicativo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(aplicativo);
    }
}

