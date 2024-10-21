package com.PAS_T1.PAS.dominio.servicos;

import com.PAS_T1.PAS.dominio.interRepositorios.IAplicativoRepository;
import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AplicativoService {
    private  IAplicativoRepository aplicativo;



    @Autowired
    public AplicativoService(IAplicativoRepository aplicativo){
        this.aplicativo = aplicativo;
    }

    public List<AplicativoModel> aplicativosCadastrados(){
         return aplicativo.todos();
     }

    public AplicativoModel aplicativoPorCodigo(long id){
          return this.aplicativo.consultaPorId(id);
     }



}
