package com.PAS_T1.PAS.infrastructure.persistence;

import com.bcopstein.sistvendas.dominio.modelos.AplicativoModel;
import com.bcopstein.sistvendas.dominio.modelos.AssinaturaModel;
import com.bcopstein.sistvendas.dominio.persistencia.IAssinaturaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class AssinaturaRepJpa implements IAssinaturaRepository {
    private List<AssinaturaModel> assinaturas;

    public AssinaturaRepJpa(List<AssinaturaModel> assinaturas) {
        this.assinaturas = assinaturas;
    }

   @Override
    public List<AssinaturaModel> todosAssinatura() {
        return assinaturas;
    }

    @Override
    public List<List<AplicativoModel>> todosAplicativos() {
        return assinaturas.stream()
                .map(AssinaturaModel::getAplicativo)
                .collect(Collectors.toList()).reversed();
    }
/*
    @Override
    public List<ClienteModel> todosClientes() {
        return assinaturas.stream()
                .map(AssinaturaModel::getClientes)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AssinaturaModel> consultaPorId(Long codigo) {
        return assinaturas.stream()
                .filter(assinatura -> assinatura.getCodigo())
                .findFirst();
    }

    @Override
    public AssinaturaModel ConsultaporIdAssinatura(long codigo) {
        return null;
    }

    @Override
    public AssinaturaModel consultaPorIdAssinatura(long codigo) {
        return assinaturas.stream()
                .filter(assinatura -> assinatura.getCodigo() == codigo)
                .findFirst()
                .orElse(null);
    }*/
}
