package com.PAS_T1.PAS.infrastructure.gateways;

import com.PAS_T1.PAS.domain.entity.Aplicativo;
import com.PAS_T1.PAS.domain.entity.User;
import com.PAS_T1.PAS.infrastructure.persistence.AplicativoEntity;

public class AplicativoEntityMapper {

  AplicativoEntity toEntity(Aplicativo aplicativoDomainObj) {
        return new AplicativoEntity(aplicativoDomainObj.Nome(), aplicativoDomainObj.custoMensal());
    }



    Aplicativo toDomainObj(AplicativoEntity aplicativoEntity) {
        return new Aplicativo(aplicativoEntity.getNome(), aplicativoEntity.getCustoMensal());
    }
}
