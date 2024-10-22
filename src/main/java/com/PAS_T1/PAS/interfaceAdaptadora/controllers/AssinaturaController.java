package com.PAS_T1.PAS.interfaceAdaptadora.controllers;

import com.PAS_T1.PAS.aplicacao.casosDeUso.AssinaturaUseCase;
import com.PAS_T1.PAS.dominio.modelos.AssinaturaModel;
import com.PAS_T1.PAS.dominio.modelos.StatusATIVO;
import com.PAS_T1.PAS.dominio.servicos.AssinaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
public class AssinaturaController {
    private AssinaturaService assinaturaService;
    private AssinaturaUseCase assinaturaUseCase;

    @Autowired
    public AssinaturaController(AssinaturaService assinaturaService, AssinaturaUseCase assinaturaUseCase) {
        this.assinaturaService = assinaturaService;
        this.assinaturaUseCase = assinaturaUseCase;
    }


    @PostMapping("/servcad/assinaturas")
    public AssinaturaModel createNewAssinatura(@RequestBody RequestBodyObject reqBody) {
        return this.assinaturaService.criaNovaAssinatura(reqBody.getCodCliente(), reqBody.getCodApp());
    }

    @GetMapping("/servcad/assinaturas/{tipo}")
    public List<AssinaturaModel> getAssinaturas(@PathVariable StatusATIVO tipo) {
        return this.assinaturaService.getFromType(tipo);
    }

    @GetMapping("/servcad/asscli/{codcli}")
    public List<AssinaturaModel> getAssinaturasCli(@PathVariable long codcli) {
        return this.assinaturaService.getFromClienteId(codcli);
    }

    @GetMapping("/servcad/assapp/{codapp}")
    public List<AssinaturaModel> getAssinaturasApp(@PathVariable long codapp) {
        return this.assinaturaService.getFromAppId(codapp);
    }

    @GetMapping("/assinvalida/{codass}")
    public boolean getAssinaturasInvalida(@PathVariable long codass) {
        return this.assinaturaUseCase.isActive(codass);
    }

    @GetMapping("/servcad/assinaturas/fromid/{codass}")
    public AssinaturaDTO getAssinatura(@PathVariable long codass) {
        AssinaturaModel assinaturaModel = this.assinaturaService.getFromAssinaturaId(codass);
        return new AssinaturaDTO(assinaturaModel.getFimVigencia(), assinaturaModel.getId());
    }


    public static class RequestBodyObject {
        private long codCliente;
        private long codApp;

        RequestBodyObject(long codCliente, long codApp) {
            this.codCliente = codCliente;
            this.codApp = codApp;
        }

        long getCodCliente() {
            return codCliente;
        }

        long getCodApp() {
            return codApp;
        }
    }


    public class AssinaturaDTO {
        private Date expirationDate;
        private Long idAssinatura;

        AssinaturaDTO(Date expirationDate, Long idAssinatura) {
            this.expirationDate = expirationDate;
            this.idAssinatura = idAssinatura;
        }

        public Date getExpirationDate() {
            return expirationDate;
        }

        public Long getIdAssinatura() {
            return idAssinatura;
        }
    }
}
