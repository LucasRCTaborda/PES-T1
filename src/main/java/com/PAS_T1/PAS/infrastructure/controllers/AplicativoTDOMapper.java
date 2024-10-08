package com.PAS_T1.PAS.infrastructure.controllers;

import com.PAS_T1.PAS.domain.entity.Aplicativo;
import com.PAS_T1.PAS.domain.entity.User;

public class AplicativoTDOMapper {

    CreateAplicativoResponse toResponse(Aplicativo aplicativo)
    {return new CreateAplicativoResponse(aplicativo.Nome(), aplicativo.custoMensal());
    }

    public Aplicativo toAplicativo(CreateAplicativoRequest request) {
        return new Aplicativo(request.Nome(), request.custoMensal());
    }
}
