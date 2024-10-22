package com.PAS_T1.PAS.dominio.servicos;

import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.RepoImpl.AplicativoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AplicativoService {

    private AplicativoRepositoryImpl aplicativoRepositoryImpl;

    @Autowired
    public AplicativoService(AplicativoRepositoryImpl aplicativoRepositoryImpl) {
        this.aplicativoRepositoryImpl = aplicativoRepositoryImpl;
    }

    public List<AplicativoModel> findAll() {
        return aplicativoRepositoryImpl.findAll();
    }

    public AplicativoModel atualizaCustoMensal(long id, double custoMensal) {
        AplicativoModel aplicativo = this.aplicativoRepositoryImpl.findById(id);
        if (aplicativo != null) {
            aplicativo.setCustoMensal(custoMensal);
            return this.aplicativoRepositoryImpl.save(aplicativo);
        }
        return null;
    }
}