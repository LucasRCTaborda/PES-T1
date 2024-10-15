package com.PAS_T1.PAS.dominio.modelos;


import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.AssinaturaRepJpa;
import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.implemREpositorios.ClienteRepJpa;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AssinaturaModel {

    @Id
    @GeneratedValue
    private long codigo;
    private Date inicioVigencia;
    private Date fimVigencia;

    private ClienteModel clientes;
    private AplicativoModel aplicativos;

    private StatusATIVO statusATIVO;


    public AssinaturaModel(long codigo) {
        this.codigo = codigo;

    }

    public AssinaturaModel(long codigo, long id_aplicativo, long id_cliente, Date inicioVigencia, Date fimVigencia, StatusATIVO statusATIVO) {
        this.codigo = codigo;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.clientes = clientes;
        this.aplicativos = aplicativos;
        this.statusATIVO = statusATIVO;
    }


    public AssinaturaModel() {
    }

    public StatusATIVO getStatusATIVO() {
        return statusATIVO;
    }

    public long getCodigo() {
        return codigo;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    public ClienteModel getClientes() {
        return clientes;
    }

    public AplicativoModel getAplicativos() {
        return aplicativos;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public void setFimVigencia(Date fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public void setClientes(ClienteModel clientes) {
        this.clientes = clientes;
    }

    public void setAplicativos(AplicativoModel aplicativos) {
        this.aplicativos = aplicativos;
    }

    public void setStatusATIVO(StatusATIVO statusATIVO) {
        this.statusATIVO = statusATIVO;
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
            long codx = umcliente.getcodigo();

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


}





