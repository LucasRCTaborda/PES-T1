package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios;


import com.PAS_T1.PAS.dominio.interRepositorios.IAplicativoRepository;
import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Aplicativo;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.JPARep.AplicativoJpa_itfRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class AplicativoRepJpa implements IAplicativoRepository {
    private final AplicativoJpa_itfRep aplicativoRepository;

    @Autowired
    public AplicativoRepJpa(AplicativoJpa_itfRep aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    @Override
    public List<AplicativoModel> todos() {
        List<Aplicativo> aplicativos = aplicativoRepository.findAll();
        if (aplicativos.size() == 0) {
            return new LinkedList<AplicativoModel>();
        } else {
            return aplicativos.stream()
                    .map(prod -> Aplicativo.toAplicativoModel(prod))
                    .toList();
        }
    }

    @Override
    public AplicativoModel consultaPorId(long id) {
        Optional<Aplicativo> aplicativoOptional = Optional.ofNullable(aplicativoRepository.findById(id));
        if (aplicativoOptional.isPresent()) {
            Aplicativo aplicativo = aplicativoOptional.get();
            return Aplicativo.toAplicativoModel(aplicativo);
        } else {
            return null; // Ou lance uma exceção, dependendo da sua lógica
        }
    }


    @Override
    public AplicativoModel AtualizaCusto(long id, double valor) {
        List<AplicativoModel> todosApp = todos();
        AplicativoModel umEx = null;
        for (AplicativoModel umapp : todosApp) {
            if (umapp.getCodigo() == id) {
                umapp.setCustoMensal(valor);
                umEx = umapp;

            }

        }
        return umEx;
    }

    public void save(AplicativoModel aplicativoModel) {
        // Converte o AplicativoModel em uma entidade Aplicativo
        Aplicativo aplicativoEntity = Aplicativo.fromAplicativoModel(aplicativoModel);
        // Salva a entidade no banco de dados usando o repositório JPA
        aplicativoRepository.save(aplicativoEntity);
    }
}





