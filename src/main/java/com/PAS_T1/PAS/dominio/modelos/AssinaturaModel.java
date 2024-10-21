package com.PAS_T1.PAS.dominio.modelos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;


public class AssinaturaModel {

    @Id
    @GeneratedValue
    private long codigo;

    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    private ClienteModel clienteModel;

    @ManyToOne // Assume que um aplicativo pode ter várias assinaturas
    private AplicativoModel aplicativos;

    private StatusATIVO statusATIVO;
    private String codAssinatura;

    // Construtor vazio para o JPA
    public AssinaturaModel() {
    }

    public AssinaturaModel(long codigo, ClienteModel clientes, AplicativoModel aplicativos, LocalDate inicioVigencia, LocalDate fimVigencia, StatusATIVO statusATIVO, String codAssinatura) {
        this.codigo = codigo;
        this.clienteModel = clientes;
        this.aplicativos = aplicativos;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.statusATIVO = statusATIVO;
        this.codAssinatura = codAssinatura;
    }

    @Override
    public String toString() {
        return "AssinaturaModel{" +
                "codigo=" + codigo +
                ", inicioVigencia=" + inicioVigencia +
                ", fimVigencia=" + fimVigencia +
                ", clientes=" + clienteModel +
                ", aplicativos=" + aplicativos +
                ", statusATIVO=" + statusATIVO +
                ", codAssinatura='" + codAssinatura + '\'' +
                '}';
    }

    // Getters e Setters
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(LocalDate inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(LocalDate fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public ClienteModel getClientes() {
        return clienteModel;
    }

    public void setClientes(ClienteModel clientes) {
        this.clienteModel = clientes;
    }

    public AplicativoModel getAplicativos() {
        return aplicativos;
    }

    public void setAplicativos(AplicativoModel aplicativos) {
        this.aplicativos = aplicativos;
    }

    public StatusATIVO getStatusATIVO() {
        return statusATIVO;
    }

    public void setStatusATIVO(StatusATIVO statusATIVO) {
        this.statusATIVO = statusATIVO;
    }

    public String getCodAssinatura() {
        return codAssinatura;
    }

    public void setCodAssinatura(String codAssinatura) {
        this.codAssinatura = codAssinatura;
    }


}
