package com.PAS_T1.PAS.aplicacao.dtos;

import com.PAS_T1.PAS.dominio.modelos.AssinaturaModel;
import com.PAS_T1.PAS.dominio.modelos.StatusATIVO;

import java.util.Date;

public class AssinaturaDTO {
/*
    private long codigo;
    private long id_aplicativo;
    private long id_cliente;
    private Date inicioVigencia;
    private Date fimVigencia;
    private StatusATIVO statusATIVO;
    private String codAssinatura;

    // Construtor padrão
    public AssinaturaDTO(long codigo, long id_aplicativo, long id_cliente, Date inicioVigencia, Date fimVigencia, StatusATIVO statusATIVO, String codAssinatura) {
        this.codigo = codigo;
        this.id_aplicativo = id_aplicativo;
        this.id_cliente = id_cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.statusATIVO = statusATIVO;
        this.codAssinatura = codAssinatura;
    }


    public AssinaturaDTO(AssinaturaModel assinatura) {
        this.codigo = assinatura.getId();
        this.id_aplicativo = assinatura.getAplicativo().getId();
        this.id_cliente = assinatura.getCliente().getId();
        this.inicioVigencia = assinatura.getInicioVigencia();
        this.fimVigencia = assinatura.getFimVigencia();

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

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(Date fimVigencia) {
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
                assinaturaModel.getId(),
                assinaturaModel.getAplicativo().getId(),
                assinaturaModel.getCliente().getId(),
                assinaturaModel.getInicioVigencia(),
                assinaturaModel.getFimVigencia(),

        );
    }*/
}
