package com.PAS_T1.PAS.application.usecases;


import com.bcopstein.sistvendas.aplicacao.dtos.AssinaturaDTO;
import com.bcopstein.sistvendas.dominio.modelos.AssinaturaModel;
import com.bcopstein.sistvendas.dominio.modelos.ClienteModel;
import com.bcopstein.sistvendas.dominio.persistencia.IAplicativoRepository;
import com.bcopstein.sistvendas.dominio.persistencia.IClienteRepository;


import com.bcopstein.sistvendas.dominio.servicos.AssinaturaService;
import org.springframework.stereotype.Component;


import java.util.List;
@Component

public class CriaAssinaturaUC {
    private IAplicativoRepository appRep;
    private IClienteRepository cliRep;

    private AssinaturaService ass;


    public CriaAssinaturaUC(IAplicativoRepository appRep, IClienteRepository cliRep){
        this.appRep = appRep;
        this.cliRep = cliRep;
    }

    public List<ClienteModel> Clientes(){
      List<ClienteModel> cli;
      cli = cliRep.todos();
            return cli;

    }
    public AssinaturaDTO run(long ID_cli, long ID_app){

           AssinaturaModel assinatura =  ass.criarAssinaturaComClienteEAplicativo(ID_cli,ID_app);
            return AssinaturaDTO.fromModel(assinatura);
        }

    @Override
    public String toString() {
        return "CriaAssinaturaUC{" +
                "codigo=" + ass.getCodigo() +
                ", cliente=" + ass.getCliente() +
                ", aplicativo=" + ass.getAplicativo() +
                ", inicioVigencia=" + ass.getInicioVigencia() +
                ", fimVigencia=" + ass.getFimVigencia() +
                ", statusATIVO=" + ass.getStatusATIVO() +
                '}';
    }

}
