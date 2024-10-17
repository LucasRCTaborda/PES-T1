package com.PAS_T1.PAS.dominio.servicos;

import com.PAS_T1.PAS.dominio.interRepositorios.IAplicativoRepository;
import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServicoAtualizaCustoMensal {

    private IAplicativoRepository aplicativo;

    @Value("${novo.custo:0}")  // Injeção de um valor default a partir de application.properties
    private double novoCusto;

    @Autowired
    public ServicoAtualizaCustoMensal(IAplicativoRepository aplicativo) {
        this.aplicativo = aplicativo;
    }

    public AplicativoModel produtoPorCodigo(long id) {
        return this.aplicativo.consultaPorId(id);
    }

    public void atualizaCusto(long id, double preco) {
        aplicativo.AtualizaCusto(id, preco);
    }
}
