package com.PAS_T1.PAS.interfaceAdaptadora.controllers;

import com.PAS_T1.PAS.aplicacao.casosDeUso.TodosOsAplicativos;
import com.PAS_T1.PAS.aplicacao.dtos.AplicativoDTO;
import com.PAS_T1.PAS.dominio.modelos.*;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private ClienteRepJpa clienteRepJpa;
    @Autowired
    private AplicativoRepJpa aplicativoRepJpa;
    @Autowired
    private AssinaturaRepJpa assinaturaRepJpa;
    @Autowired
    private UsuarioRepJpa usuarioRepJpa;
    @Autowired
    private PagamentoRepJpa pagamentoRepJpa;

    public Controller(ClienteRepJpa clienteRepJpa,
                      AplicativoRepJpa aplicativoRepJpa,
                      AssinaturaRepJpa assinaturaRepJpa,
                      UsuarioRepJpa usuarioRepJpa,
                      PagamentoRepJpa pagamentoRepJpa) {
        this.clienteRepJpa = clienteRepJpa;
        this.aplicativoRepJpa = aplicativoRepJpa;
        this.assinaturaRepJpa = assinaturaRepJpa;
        this.usuarioRepJpa = usuarioRepJpa;
        this.pagamentoRepJpa = pagamentoRepJpa;
    }


    //Lista com todos os clientes cadastrados
    @GetMapping("/clientes")
    public List<ClienteModel> todosClientes() {
        return clienteRepJpa.todos();
    }
    //----------------------------------------------------------------------------------------------------------------------
    //Lista com todos os clientes Aplicativos
    @GetMapping("/aplicativos")
    public List<AplicativoModel> todosAplicativos() {
        return aplicativoRepJpa.todos();
    }

    @GetMapping("todosAplicativos")
    @CrossOrigin(origins = "*")
    public List<AplicativoDTO> todosAplicativosx(){
        TodosOsAplicativos todosapp = null;
        return todosapp.run();
    }

    //----------------------------------------------------------------------------------------------------------------------
    @GetMapping("/pagamentos")
    public List<PagamentoModel> todosPagamentos() {
        return pagamentoRepJpa.todos();
    }
    //----------------------------------------------------------------------------------------------------------------------
    @GetMapping("/usuarios")
    public List<UsuarioModel> todosUsuarios() {
        return usuarioRepJpa.todos();
    }
    //----------------------------------------------------------------------------------------------------------------------
    @PostMapping("/assinaturas/{codigodocliente}/{codigodoaplicativo}")
    public AssinaturaModel criaAssinatura(@PathVariable long codigodocliente, @PathVariable long codigodoaplicativo) {
        ClienteModel modelCliente = null;
        AplicativoModel modelAplicativo = null;


        List<ClienteModel> todosClientes = clienteRepJpa.todos();
        for (ClienteModel umcliente : todosClientes) {
            if (umcliente.getcodigo() == codigodocliente) {
                modelCliente = umcliente;
                break;
            }
        }


        List<AplicativoModel> todosApp = todosAplicativos();
        for (AplicativoModel umapp : todosApp) {
            if (umapp.getCodigo() == codigodoaplicativo) {
                modelAplicativo = umapp;
                break;
            }
        }

        AssinaturaModel assinaturaModel = new AssinaturaModel();
        if (modelCliente != null && modelAplicativo != null) {
            assinaturaModel = assinaturaModel.criarAssinaturaComClienteEAplicativo(modelCliente, modelAplicativo);
        } else {

        }

        return assinaturaModel;
    }
//----------------------------------------------------------------------------------------------------------------------

    @PostMapping("/Aplicativo/atualizacaocusto/{codigodocliente}/{codigodoaplicativo}")
    public AplicativoModel AtualizaCusto(@PathVariable long codigodocliente, @PathVariable long custo) {

        AplicativoModel modelAplicativo = null;
        AplicativoModel um = null;
        List<AplicativoModel> todosApp = todosAplicativos();
        for (AplicativoModel umapp : todosApp) {
            if (umapp.getCodigo() == codigodocliente) {
                modelAplicativo = umapp;
                break;
            }
            um =modelAplicativo;

            modelAplicativo.setCustoMensal(custo);

        }

        return um;
    }





















//----------------------------------------------------------------------------------------------------------------------

    @GetMapping("/controller")
    public String controllerEndpoint() {
        return "Este é o endpoint do Controller!";
    }
    //----------------------------------------------------------------------------------------------------------------------
    @GetMapping("a")
    @CrossOrigin(origins = "*")
    public String welcomeMessage(){
        return "Bem vindo as lojas ACME";
    }
    //----------------------------------------------------------------------------------------------------------------------
    @GetMapping("/test")
    public String testEndpoint() {
        return "This is a test endpoint!";
    }
}