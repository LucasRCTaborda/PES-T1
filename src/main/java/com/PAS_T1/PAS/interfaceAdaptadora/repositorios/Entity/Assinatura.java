package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity;


import com.PAS_T1.PAS.dominio.modelos.AssinaturaModel;
import com.PAS_T1.PAS.dominio.modelos.StatusATIVO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "assinaturas")
public class Assinatura {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "aplicativo_id")
    private Aplicativo aplicativo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private Date inicioVigencia;
    private Date fimVigencia;

    protected Assinatura() {}

    public Assinatura(long id, Aplicativo aplicativo, Cliente cliente, Date inicioVigencia, Date fimVigencia) {
        this.id = id;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public long getId() {
        return id;
    }

    public Aplicativo getAplicativo() {
        return aplicativo;
    }

    public Cliente getCliente() {
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
        return inicioVigencia.before(new Date()) && fimVigencia.after(new Date());
    }

    public static AssinaturaModel toAssinaturaModel(Assinatura assinatura) {
        return new AssinaturaModel(
                assinatura.getId(),
                Aplicativo.toAplicativoModel(assinatura.getAplicativo()),
                Cliente.toClienteModel(assinatura.getCliente()),
                assinatura.getInicioVigencia(),
                assinatura.getFimVigencia()
        );
    }

    public static Assinatura fromAssinaturaModel(AssinaturaModel assinaturaModel) {
        return new Assinatura(
                assinaturaModel.getId(),
                Aplicativo.fromAplicativoModel(assinaturaModel.getAplicativo()),
                Cliente.fromClienteModel(assinaturaModel.getCliente()),
                assinaturaModel.getInicioVigencia(),
                assinaturaModel.getFimVigencia()
        );
    }
}
