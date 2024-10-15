package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios;


import com.PAS_T1.PAS.dominio.interRepositorios.IAssinaturaRepository;
import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import com.PAS_T1.PAS.dominio.modelos.AssinaturaModel;
import com.PAS_T1.PAS.dominio.modelos.ClienteModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Repository
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
    public List<AplicativoModel> todosAplicativos() {
        return assinaturas.stream()
                .map(assinatura -> assinatura.getAplicativos())
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<ClienteModel> todosClientes() {
        return assinaturas.stream()
                .map(assinatura -> assinatura.getClientes())
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AssinaturaModel> consultaPorId(Long codigo) {
        return assinaturas.stream()
                .filter(assinatura -> assinatura.getCodigo() == codigo)
                .findFirst();
    }

    @Override
    public AssinaturaModel ConsultaporIdAssinatura(long codigo) {
        return null;
    }
}
