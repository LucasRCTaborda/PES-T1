package com.PAS_T1.PAS.dominio.servicos;

import com.PAS_T1.PAS.aplicacao.casosDeUso.CriarAssinatura;
import com.PAS_T1.PAS.aplicacao.dtos.AssinaturaDTO;
import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import com.PAS_T1.PAS.dominio.modelos.ClienteModel;
import org.springframework.stereotype.Service;
@Service
public class AssinaturaService {


}


    /*
 private final AssinaturaJPA_itfRep assinaturaJPAItfRep;
    private final ClienteRepJpa clienteRepJpa;
    private final AplicativoRepJpa aplicativoRepJpa;
    private final AssinaturaJPA_itfRep assinaturaJPAItfRep;

    private final AtomicLong contadorAssinaturas = new AtomicLong(0); // Contador para as assinaturas

    public AssinaturaService(ClienteRepJpa clienteRepJpa, AplicativoRepJpa aplicativoRepJpa, AssinaturaJPA_itfRep assinaturaJPAItfRep) {
        this.clienteRepJpa = clienteRepJpa;
        this.aplicativoRepJpa = aplicativoRepJpa;
        this.assinaturaJPAItfRep = assinaturaJPAItfRep;
    }

    public AssinaturaModel criarAssinatura(Long codigoCliente, Long codigoAplicativo) {
        // Consultar o cliente e o aplicativo
        ClienteModel cliente = clienteRepJpa.consultaPorId(codigoCliente);
        AplicativoModel aplicativo = aplicativoRepJpa.consultaPorId(codigoAplicativo);

        // Verificar se cliente e aplicativo foram encontrados
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }
        if (aplicativo == null) {
            throw new IllegalArgumentException("Aplicativo não encontrado.");
        }

        // Gerar código de assinatura
        String codigoAssinatura = gerarCodigoAssinatura();

        LocalDate dataInicio = LocalDate.now();
        LocalDate dataFim = dataInicio.plusDays(30); // Assinatura válida por 30 dias

        // Criar a nova assinatura
        AssinaturaModel novaAssinatura = new AssinaturaModel(codigoAssinatura, cliente, aplicativo, dataInicio, dataFim,);
        assinaturaJPAItfRep.save(novaAssinatura); // Persistindo a nova assinatura

        return novaAssinatura;
    }

    private String gerarCodigoAssinatura() {
        // Incrementa o contador e gera o código
        long numeroAssinatura = contadorAssinaturas.incrementAndGet(); // Incrementa o contador
        return "AS-" + LocalDate.now().toString().replace("-", "") + "-" + String.format("%03d", numeroAssinatura); // Formato: AS-20231020-001
    }
    public AssinaturaModel criarAssinaturaComClienteEAplicativo(ClienteModel cliente, AplicativoModel aplicativo) {

        AssinaturaModel assinatura = new AssinaturaModel();


        assinatura.setClientes(cliente);
        assinatura.setAplicativos(aplicativo);


        Date inicio = new Date();
        Date fim = adicionarDias(inicio, 30);
        assinatura.setInicioVigencia(inicio);
        assinatura.setFimVigencia(fim);
        assinatura.verificarStatusValido();


        return assinatura;
    }

    // Método para adicionar dias a uma data
    private Date adicionarDias(Date data, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DAY_OF_MONTH, dias);
        return calendar.getTime();
    }


    public Date inicioDate() {
        LocalDate dataAtual = LocalDate.now();
        Date date = java.sql.Date.valueOf(dataAtual);
        return date;
    }

    public static Date fimdate() {
        AssinaturaModel m1 = null;
        Date umDate = m1.getInicioVigencia();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(umDate);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        return calendar.getTime();
    }


    private final AssinaturaRepJpa assinaturaRepJpa = null;

    public AplicativoModel encontraAplicativo(long codigoAplicativo) {
        AplicativoModel modelAplicativo = null;

        List<AplicativoModel> todosAplicativos = assinaturaRepJpa.todosAplicativos();
        for (AplicativoModel umAplicativo : todosAplicativos) {
            long codx = umAplicativo.getCodigo();

            if (codx == codigoAplicativo) {
                modelAplicativo = umAplicativo;
                break;
            }
        }

        return modelAplicativo;
    }

    private final ClienteRepJpa clienteRepJpa = null;

    public ClienteModel encontrCliente(long codigoCliente) {
        ClienteModel modelCliente = null;

        List<ClienteModel> todosClientes = clienteRepJpa.todos();
        for (ClienteModel umcliente : todosClientes) {
            long codx = umcliente.getCodigo();

            if (codx == codigoCliente) {
                modelCliente = umcliente;
                break;
            }
        }

        return modelCliente;
    }

    public StatusATIVO verificarStatusValido() {
        Date inicio = inicioDate();
        Date fim = fimdate();

        if (inicio.after(fim)) {
            return StatusATIVO.ATIVO;
        } else {
            return StatusATIVO.CANCELADO;
        }
    }
}*/
