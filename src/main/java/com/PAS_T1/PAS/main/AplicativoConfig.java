package com.PAS_T1.PAS.main;

import com.PAS_T1.PAS.application.gateways.AplicativoGateway;
import com.PAS_T1.PAS.application.usecases.CreateAplicativoInteractor;
import com.PAS_T1.PAS.infrastructure.controllers.AplicativoTDOMapper;
import com.PAS_T1.PAS.infrastructure.gateways.AplicativoEntityMapper;
import com.PAS_T1.PAS.infrastructure.gateways.AplicativoRepositoryGateway;
import com.PAS_T1.PAS.infrastructure.persistence.AplicativoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AplicativoConfig {


    @Bean
    CreateAplicativoInteractor createAplicativoCase(AplicativoGateway aplicativoGateway) {
        return new CreateAplicativoInteractor(aplicativoGateway);
    }

    @Bean
    AplicativoGateway aplicativoGateway(AplicativoRepository aplicativoRepository, AplicativoEntityMapper aplicativoEntityMapper) {
        return new AplicativoRepositoryGateway(aplicativoRepository, aplicativoEntityMapper);
    }

    @Bean
    AplicativoEntityMapper aplicativoEntityMapper() {
        return new AplicativoEntityMapper();
    }

    @Bean
    AplicativoTDOMapper aplicativoDTOMapper() {
        return new AplicativoTDOMapper();
    }
}