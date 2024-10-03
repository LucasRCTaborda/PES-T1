package com.PAS_T1.PAS.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Subscription {

    @Id
    @GeneratedValue
    private long codigo;

    private Date inicioVigencia;

    private Date fimVigencia;
    @ManyToOne
    private App app;

    @ManyToOne
    private Client client;

    private StatusAtivo statusATIVO;

    public Subscription() {

    }

    public StatusAtivo getStatusATIVO() {
        return statusATIVO;
    }

    public Subscription(long codigo, long id_aplicativo, long id_cliente, Date inicioVigencia, Date fimVigencia, StatusAtivo statusATIVO) {
        this.codigo = codigo;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.app = app;
        this.client = client;

    }

    // Getters e Setters
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public App getAplicativo() {
        return app;
    }

    public void setAplicativo(App app) {
        this.app = app;
    }

    public Client getCliente() {
        return client;
    }

    public void setCliente(Client client) {
        this.client = client;
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
