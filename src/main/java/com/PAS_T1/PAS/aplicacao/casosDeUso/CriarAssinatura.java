package com.PAS_T1.PAS.aplicacao.casosDeUso;

import com.PAS_T1.PAS.aplicacao.dtos.AssinaturaDTO;
import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import com.PAS_T1.PAS.dominio.modelos.AssinaturaModel;
import com.PAS_T1.PAS.dominio.modelos.ClienteModel;
import com.PAS_T1.PAS.dominio.modelos.StatusATIVO;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.AssinaturaRepJpa;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.ClienteRepJpa;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class CriarAssinatura {

    private final AssinaturaRepJpa assinaturaRepJpa;
    private final ClienteRepJpa clienteRepJpa;

    public CriarAssinatura(AssinaturaRepJpa assinaturaRepJpa, ClienteRepJpa clienteRepJpa) {
        this.assinaturaRepJpa = assinaturaRepJpa;
        this.clienteRepJpa = clienteRepJpa;
    }


    public AssinaturaDTO criarAssinaturaComClienteEAplicativo(ClienteModel cliente, AplicativoModel aplicativo) {
        Optional<ClienteModel> optionalCliente = encontraCliente(cliente.getCodigo());
        Optional<AplicativoModel> optionalAplicativo = encontraAplicativo(aplicativo.getCodigo());

        // Verifica se o cliente e o aplicativo existem
        if (optionalCliente.isPresent() && optionalAplicativo.isPresent()) {
            ClienteModel clienteEncontrado = optionalCliente.get();
            AplicativoModel aplicativoEncontrado = optionalAplicativo.get();

            // Cria a assinatura
            AssinaturaModel assinatura = new AssinaturaModel();
            assinatura.setClientes(clienteEncontrado);
            assinatura.setAplicativos(aplicativoEncontrado);

            LocalDate inicio = LocalDate.now(); // Corrigido para obter a data atual
            assinatura.setInicioVigencia(inicio);

            LocalDate fim = inicio.plusDays(30); // Adiciona 30 dias diretamente
            assinatura.setFimVigencia(fim);

            // Verifica o status da assinatura
            StatusATIVO status = verificarStatusValido(inicio, fim);
            assinatura.setStatusATIVO(status);

            // Converter a assinatura para DTO
            return AssinaturaDTO.fromModel(assinatura); // Certifique-se de implementar o método fromModel na classe AssinaturaDTO
        } else {
            // Lidar com o caso em que o cliente ou aplicativo não foi encontrado
            throw new IllegalArgumentException("Cliente ou aplicativo não encontrado.");
        }
    }




    private Date adicionarDias(Date data, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DAY_OF_MONTH, dias);
        return calendar.getTime();
    }


    public Date inicioDate() {
        LocalDate dataAtual = LocalDate.now();
        return java.sql.Date.valueOf(dataAtual);
    }


    public Date calcularFimVigencia(Date inicio) {
        return adicionarDias(inicio, 30);
    }


    public Date converterLocalDateParaDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }


    public LocalDate obterDataAtual() {
        return LocalDate.now();
    }

    public long calcularDiasRestantes(Date fimVigencia) {
        LocalDate dataFim = converterDateParaLocalDate(fimVigencia);
        LocalDate dataAtual = obterDataAtual();

        // Calcula a diferença em dias
        long diasRestantes = ChronoUnit.DAYS.between(dataAtual, dataFim);

        return diasRestantes >= 0 ? diasRestantes : 0; // Retorna 0 se a data já passou
    }

    // Método auxiliar para converter Date para LocalDate
    private LocalDate converterDateParaLocalDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }





    public Optional<AplicativoModel> encontraAplicativo(long codigoAplicativo) {

        return assinaturaRepJpa.todosAplicativos().stream()
                .filter(app -> app.getCodigo() == codigoAplicativo)
                .findFirst(); // Retorna um Optional para evitar NullPointerException
    }

    public Optional<ClienteModel> encontraCliente(long codigoCliente) {

        return clienteRepJpa.todos().stream()
                .filter(cliente -> cliente.getCodigo() == codigoCliente)
                .findFirst(); // Retorna um Optional para evitar NullPointerException
    }

    public StatusATIVO verificarStatusValido(LocalDate inicioVigencia, LocalDate fimVigencia) {
        LocalDate dataAtual = LocalDate.now();

        LocalDate inicio = (inicioVigencia);
        LocalDate fim = (fimVigencia);

        if (!dataAtual.isBefore(inicio) && !dataAtual.isAfter(fim)) {
            return StatusATIVO.ATIVO;
        } else {
            return StatusATIVO.CANCELADO;
        }
    }


}
