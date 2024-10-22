package com.PAS_T1.PAS.aplicacao.casosDeUso;

import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Assinatura;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.AssinaturaRepJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssinaturaUseCase {
    AssinaturaRepJpa assinaturaRepositoryJpa;

    @Autowired
    public AssinaturaUseCase (AssinaturaRepJpa assinaturaRepositoryJpa){
        this.assinaturaRepositoryJpa = assinaturaRepositoryJpa;
    }

    public Boolean isActive(long id){
        Assinatura assinatura = this.assinaturaRepositoryJpa.findById(id);

        if(assinatura != null){
            return assinatura.isActive();
        }
        return null;
    }
}
