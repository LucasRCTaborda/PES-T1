package com.PAS_T1.PAS.infrastructure.gateways;

import com.PAS_T1.PAS.application.gateways.AplicativoGateway;
import com.PAS_T1.PAS.domain.entity.Aplicativo;
import com.PAS_T1.PAS.infrastructure.persistence.AplicativoEntity;
import com.PAS_T1.PAS.infrastructure.persistence.AplicativoRepository;

public class AplicativoRepositoryGateway implements AplicativoGateway {

    private final AplicativoRepository aplicativoRepository;
    private final AplicativoEntityMapper aplicativoEntityMapper;


    public AplicativoRepositoryGateway(AplicativoRepository aplicativoRepository,
                                       AplicativoEntityMapper aplicativoEntityMapper) {
        this.aplicativoRepository = aplicativoRepository;
        this.aplicativoEntityMapper = aplicativoEntityMapper;
    }

    // Corrigido para 'createAplicativo'
    @Override
    public Aplicativo createAplicativo(Aplicativo aplicativoDomainObj) {
        AplicativoEntity aplicativoEntity = aplicativoEntityMapper.toEntity(aplicativoDomainObj);
        AplicativoEntity savedEntity;
        savedEntity = aplicativoRepository.save(aplicativoEntity);

        return aplicativoEntityMapper.toDomainObj(savedEntity);
    }
}