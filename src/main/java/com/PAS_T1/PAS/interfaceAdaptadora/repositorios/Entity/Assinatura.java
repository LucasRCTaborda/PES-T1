package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity;


import com.PAS_T1.PAS.dominio.modelos.StatusATIVO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Assinatura {

    @Id
    @GeneratedValue
    private long codigo;

    private Date inicioVigencia;

    private Date fimVigencia;
    @ManyToOne
    private Aplicativo aplicativo;

    @ManyToOne
    private Cliente cliente;

    private StatusATIVO statusATIVO;

    public Assinatura() {

    }

    public StatusATIVO getStatusATIVO() {
        return statusATIVO;
    }

    public Assinatura(long codigo, long id_aplicativo, long id_cliente, Date inicioVigencia, Date fimVigencia, StatusATIVO statusATIVO) {
        this.codigo = codigo;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.statusATIVO = statusATIVO;
    }

    // Getters e Setters
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Aplicativo getAplicativo() {
        return aplicativo;
    }

    public void setAplicativo(Aplicativo aplicativo) {
        this.aplicativo = aplicativo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
}
