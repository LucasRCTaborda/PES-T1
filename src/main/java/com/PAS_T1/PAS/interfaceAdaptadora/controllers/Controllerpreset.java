package com.PAS_T1.PAS.interfaceAdaptadora.controllers;

import com.PAS_T1.PAS.dominio.modelos.*;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controllerpreset {
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

    public Controllerpreset(ClienteRepJpa clienteRepJpa,
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

    // Lista com todos os clientes cadastrados
    @GetMapping("/servcad/clientes")
    public List<ClienteModel> todosClientes() {
        return clienteRepJpa.todos();
    }

    // Lista com todos os aplicativos <<<<<<<<<<<<<<<<<<<NÃO FUNCIONA
    @GetMapping("/servcad/aplicativos")
    public List<AplicativoModel> todosAplicativos() {
        return aplicativoRepJpa.todos();
    }

    // Criação de uma nova assinatura <<<< NÃO FUNCIONA
    @PostMapping("/servcad/assinatura/{codigodocliente}/{codigodoaplicativo}")
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
        }

        return assinaturaModel;
    }

    // Atualização do custo mensal de um aplicativo <<<< NÃO FUNCIONA
    @PostMapping("/servcad/aplicativos/atualizacusto/{idAplicativo}/{custoMensal}")
    public AplicativoModel AtualizaCusto(@PathVariable long idAplicativo, @PathVariable long custoMensal) {
        AplicativoModel modelAplicativo = null;
        List<AplicativoModel> todosApp = todosAplicativos();
        for (AplicativoModel umapp : todosApp) {
            if (umapp.getCodigo() == idAplicativo) {
                modelAplicativo = umapp;
                modelAplicativo.setCustoMensal(custoMensal);
                break;
            }
        }
        return modelAplicativo;
    }
    /*
        // Lista assinaturas por tipo
        @GetMapping("/servcad/assinaturas/{tipo}")
        public List<AssinaturaModel> listarAssinaturasPorTipo(@PathVariable String tipo) {
            return assinaturaRepJpa.buscarPorTipo(tipo);
        }

        // Lista assinaturas de um cliente específico
        @GetMapping("/servcad/asscli/{codcli}")
        public List<AssinaturaModel> listarAssinaturasPorCliente(@PathVariable long codcli) {
            return assinaturaRepJpa.buscarPorCliente(codcli);
        }

        // Lista assinaturas de um aplicativo específico
        @GetMapping("/servcad/assapp/{codapp}")
        public List<AssinaturaModel> listarAssinaturasPorAplicativo(@PathVariable long codapp) {
            return assinaturaRepJpa.buscarPorAplicativo(codapp);
        }

        // Receber a notificação de pagamento de uma assinatura
        @PostMapping("/registrarpagamento")
        public PagamentoModel registrarPagamento(@RequestBody PagamentoModel pagamentoModel) {
            return pagamentoRepJpa.salvar(pagamentoModel);
        }

        // Verificar se uma assinatura é válida
        @GetMapping("/assinvalida/{codass}")
        public boolean verificarAssinaturaValida(@PathVariable long codass) {
            return assinaturaRepJpa.verificarValidade(codass);
        }
    */
    // Test Endpoints

}
