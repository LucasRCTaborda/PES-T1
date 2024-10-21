package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity;


import com.PAS_T1.PAS.dominio.modelos.StatusATIVO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;


@Entity
public class Assinatura {



    @Id
    @GeneratedValue
    private long codigo;

    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Aplicativo aplicativo;

    private StatusATIVO statusATIVO;
    private String codAssinatura;


    public Assinatura() {
    }

    public Assinatura(long codigo, Cliente cliente, Aplicativo aplicativo, LocalDate inicioVigencia, LocalDate fimVigencia, StatusATIVO statusATIVO, String codAssinatura) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.aplicativo = aplicativo;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.statusATIVO = statusATIVO;
        this.codAssinatura = codAssinatura;
    }

    @Override
    public String toString() {
        return "Assinatura{" +
                "codigo=" + codigo +
                ", inicioVigencia=" + inicioVigencia +
                ", fimVigencia=" + fimVigencia +
                ", clienteModel=" + cliente+
                ", aplicativos=" + aplicativo +
                ", statusATIVO=" + statusATIVO +
                ", codAssinatura='" + codAssinatura + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assinatura)) return false;
        Assinatura that = (Assinatura) o;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(codigo);
    }

    public long getCodigo() {
        return codigo;
    }

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Aplicativo getAplicativo() {
        return aplicativo;
    }

    public StatusATIVO getStatusATIVO() {
        return statusATIVO;
    }

    public String getCodAssinatura() {
        return codAssinatura;
    }
}
