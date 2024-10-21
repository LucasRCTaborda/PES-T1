package com.PAS_T1.PAS.aplicacao.dtos;

import com.PAS_T1.PAS.dominio.modelos.AssinaturaModel;
import com.PAS_T1.PAS.dominio.modelos.StatusATIVO;

import java.time.LocalDate;

public class AssinaturaDTO {

    private long codigo;
    private long id_aplicativo;
    private long id_cliente;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
    private StatusATIVO statusATIVO;
    private String codAssinatura;

    // Construtor padrão
    public AssinaturaDTO(long codigo, long id_aplicativo, long id_cliente, LocalDate inicioVigencia, LocalDate fimVigencia, StatusATIVO statusATIVO, String codAssinatura) {
        this.codigo = codigo;
        this.id_aplicativo = id_aplicativo;
        this.id_cliente = id_cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.statusATIVO = statusATIVO;
        this.codAssinatura = codAssinatura;
    }

    // Construtor que converte AssinaturaModel para AssinaturaDTO
    public AssinaturaDTO(AssinaturaModel assinatura) {
        this.codigo = assinatura.getCodigo();
        this.id_aplicativo = assinatura.getAplicativos().getCodigo(); // ID do aplicativo
        this.id_cliente = assinatura.getClientes().getCodigo();       // ID do cliente
        this.inicioVigencia = assinatura.getInicioVigencia();
        this.fimVigencia = assinatura.getFimVigencia();
        this.statusATIVO = assinatura.getStatusATIVO();               // Método que retorna o status
        this.codAssinatura = assinatura.getCodAssinatura();          // Capturando o código da assinatura
    }

    // Getters e Setters
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getId_aplicativo() {
        return id_aplicativo;
    }

    public void setId_aplicativo(long id_aplicativo) {
        this.id_aplicativo = id_aplicativo;
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
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

    // Método estático para converter de AssinaturaModel para AssinaturaDTO
    public static AssinaturaDTO fromModel(AssinaturaModel assinaturaModel) {
        return new AssinaturaDTO(
                assinaturaModel.getCodigo(),
                assinaturaModel.getAplicativos().getCodigo(), // ID do aplicativo
                assinaturaModel.getClientes().getCodigo(),    // ID do cliente
                assinaturaModel.getInicioVigencia(),
                assinaturaModel.getFimVigencia(),
                assinaturaModel.getStatusATIVO(),              // Método que retorna o status
                assinaturaModel.getCodAssinatura()             // Capturando o código da assinatura
        );
    }
}
