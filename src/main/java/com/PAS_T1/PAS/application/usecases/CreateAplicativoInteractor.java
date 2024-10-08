package com.PAS_T1.PAS.application.usecases;

import com.PAS_T1.PAS.application.gateways.AplicativoGateway;
import com.PAS_T1.PAS.domain.entity.Aplicativo;

public class CreateAplicativoInteractor {
    private final AplicativoGateway aplicativoGateway;

    public CreateAplicativoInteractor(AplicativoGateway aplicativoGateway) {
        this.aplicativoGateway = aplicativoGateway;
    }

    public Aplicativo createAplicativo(Aplicativo aplicativo) {
        return aplicativoGateway.createAplicativo(aplicativo);
    }}