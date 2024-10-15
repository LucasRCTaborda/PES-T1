package interfaceAdaptadora;

import dominio.modelos.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import persistencia.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    private final ClienteRepJpa clienteRepJpa;
    private final AplicativoRepJpa aplicativoRepJpa;
    private final AssinaturaRepJpa assinaturaRepJpa;
    private final UsuarioRepJpa usuarioRepJpa;
    private final PagamentoRepJpa pagamentoRepJpa;

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

    @GetMapping("/")
    @CrossOrigin(origins = "*")
    public String welcomeMessage() {
        return "Bem-vindo às lojas ACME";
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "This is a test endpoint!";
    }

    @GetMapping("/clientes")
    public List<ClienteModel> todosClientes() {
        return clienteRepJpa.todos();
    }

    @GetMapping("/aplicativos")
    public List<AplicativoModel> todosAplicativos() {
        return aplicativoRepJpa.todos();
    }

    @GetMapping("/assinaturas")
    public List<AssinaturaModel> todasAssinaturas() {
        return assinaturaRepJpa.todosAssinatura();
    }

    @GetMapping("/pagamentos")
    public List<PagamentoModel> todosPagamentos() {
        return pagamentoRepJpa.todos();
    }

    @GetMapping("/usuarios")
    public List<UsuarioModel> todosUsuarios() {
        return usuarioRepJpa.todos();
    }
}
