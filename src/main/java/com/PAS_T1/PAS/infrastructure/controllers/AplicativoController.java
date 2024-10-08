package com.PAS_T1.PAS.infrastructure.controllers;

import com.PAS_T1.PAS.application.usecases.CreateAplicativoInteractor;
import com.PAS_T1.PAS.domain.entity.Aplicativo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/aplicativos")
public class AplicativoController {

    private final CreateAplicativoInteractor createAplicativoInteractor;
    private final AplicativoTDOMapper aplicativoDTOMapper;

    public AplicativoController(CreateAplicativoInteractor createAplicativoInteractor,
                                AplicativoTDOMapper aplicativoDTOMapper) {
        this.createAplicativoInteractor = createAplicativoInteractor;
        this.aplicativoDTOMapper = aplicativoDTOMapper;
    }

    @PostMapping
    public CreateAplicativoResponse createAplicativo(@RequestBody CreateAplicativoRequest request) {
        // Converte a requisição DTO para o objeto de negócio Aplicativo
        Aplicativo aplicativoBusinessObj = aplicativoDTOMapper.toAplicativo(request);
        // Usa o caso de uso para criar o aplicativo
        Aplicativo aplicativo = createAplicativoInteractor.createAplicativo(aplicativoBusinessObj);
        // Converte o objeto de negócio para a resposta DTO
        return aplicativoDTOMapper.toResponse(aplicativo);
    }
}