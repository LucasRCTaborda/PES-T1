package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.RepoImpl;


import com.PAS_T1.PAS.dominio.interRepositorios.IAssinaturaRepository;
import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import com.PAS_T1.PAS.dominio.modelos.AssinaturaModel;
import com.PAS_T1.PAS.dominio.modelos.ClienteModel;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Aplicativo;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Assinatura;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Cliente;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.AssinaturaRepJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssinaturaRepositoryImpl implements IAssinaturaRepository {

    private AssinaturaRepJpa assinaturaRepositoryJpa;

    @Autowired
    public AssinaturaRepositoryImpl(AssinaturaRepJpa assinaturaRepositoryJpa) {
        this.assinaturaRepositoryJpa = assinaturaRepositoryJpa;
    }

    @Override
    public List<AssinaturaModel> findAll() {
        return assinaturaRepositoryJpa.findAll().stream().map(Assinatura::toAssinaturaModel).toList();
    }

    @Override
    public List<AssinaturaModel> findByCliente(ClienteModel cliente) {
        return assinaturaRepositoryJpa.findByCliente(Cliente.fromClienteModel(cliente)).stream().map(Assinatura::toAssinaturaModel).toList();
    }

    @Override
    public List<AssinaturaModel> findByAplicativo(AplicativoModel aplicativo) {
        return assinaturaRepositoryJpa.findByAplicativo(Aplicativo.fromAplicativoModel(aplicativo)).stream().map(Assinatura::toAssinaturaModel).toList();
    }

    @Override
    public List<AssinaturaModel> findByAplicativoId(Long id) {
        return assinaturaRepositoryJpa.findByAplicativoId(id).stream().map(Assinatura::toAssinaturaModel).toList();
    }

    @Override
    public List<AssinaturaModel> findByClienteId(long id) {
        return assinaturaRepositoryJpa.findByClienteId(id).stream().map(Assinatura::toAssinaturaModel).toList();
    }

    @Override
    public AssinaturaModel findById(long id) {
        return Assinatura.toAssinaturaModel(assinaturaRepositoryJpa.findById(id));
    }

    @Override
    public List<AssinaturaModel> findActiveAssinaturas() {
        return assinaturaRepositoryJpa.findActiveAssinaturas().stream().map(Assinatura::toAssinaturaModel).toList();
    }

    @Override
    public List<AssinaturaModel> findInactiveAssinaturas() {
        return assinaturaRepositoryJpa.findInactiveAssinaturas().stream().map(Assinatura::toAssinaturaModel).toList();
    }

    @Override
    public Long findLastAssinaturaId() {
        return assinaturaRepositoryJpa.findLastAssinaturaId();
    }

    @Override
    public AssinaturaModel save(AssinaturaModel assinatura) {
        return Assinatura.toAssinaturaModel(assinaturaRepositoryJpa.save(Assinatura.fromAssinaturaModel(assinatura)));
    }
}

