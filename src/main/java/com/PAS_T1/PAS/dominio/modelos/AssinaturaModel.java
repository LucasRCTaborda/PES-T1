package com.PAS_T1.PAS.dominio.modelos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.Date;


public class AssinaturaModel {
    private long id;
    private ClienteModel cliente;
    private AplicativoModel aplicativo;
    private Date inicioVigencia;
    private Date fimVigencia;

    public AssinaturaModel(long id, AplicativoModel aplicativo, ClienteModel cliente, Date inicioVigencia, Date fimVigencia) {
        this.id = id;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public long getId() {
        return id;
    }

    public AplicativoModel getAplicativo() {
        return aplicativo;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(Date fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public boolean isActive() {
        return inicioVigencia.before(new Date(System.currentTimeMillis())) && fimVigencia.after(new Date(System.currentTimeMillis()));
    }
}
