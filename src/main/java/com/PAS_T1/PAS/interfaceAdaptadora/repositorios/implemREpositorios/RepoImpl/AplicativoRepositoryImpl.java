package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.RepoImpl;

import com.PAS_T1.PAS.dominio.interRepositorios.IAplicativoRepository;
import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Aplicativo;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.AplicativoRepJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AplicativoRepositoryImpl implements IAplicativoRepository {

    private AplicativoRepJpa aplicativoRepositoryJpa;

    @Autowired
    public AplicativoRepositoryImpl(AplicativoRepJpa aplicativoRepositoryJpa) {
        this.aplicativoRepositoryJpa = aplicativoRepositoryJpa;
    }

    @Override
    public List<AplicativoModel> findAll() {
        return aplicativoRepositoryJpa.findAll().stream().map(Aplicativo::toAplicativoModel).toList();
    }

    @Override
    public AplicativoModel findById(long id) {
        return Aplicativo.toAplicativoModel(aplicativoRepositoryJpa.findById(id));
    }

    @Override
    public List<AplicativoModel> findByNome(String nome) {
        return aplicativoRepositoryJpa.findByNome(nome).stream().map(Aplicativo::toAplicativoModel).toList();
    }

    @Override
    public List<AplicativoModel> findByCustoMensal(double custoMensal) {
        return aplicativoRepositoryJpa.findByCustoMensal(custoMensal).stream().map(Aplicativo::toAplicativoModel).toList();
    }

    @Override
    public AplicativoModel save(AplicativoModel aplicativo) {
        return Aplicativo.toAplicativoModel(aplicativoRepositoryJpa.save(Aplicativo.fromAplicativoModel(aplicativo)));
    }
}
