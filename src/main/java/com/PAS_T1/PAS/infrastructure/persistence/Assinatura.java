package com.PAS_T1.PAS.infrastructure.persistence;


import com.bcopstein.sistvendas.dominio.modelos.StatusATIVO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Assinatura {

    @Id
    @GeneratedValue
    private long codigo;
    @Column(name = "Inicio_Vigencia", nullable = false)
    private Date inicio_vigencia;
    @Column(name = "Fim_Vigencia", nullable = false)
    private Date fim_vigencia;
    @ManyToOne
    private Aplicativo aplicativo;

    @ManyToOne
    private Cliente cliente;





    public Assinatura() {

    }



    public Assinatura(long codigo, Aplicativo aplicativo, Cliente cliente, Date inicioVigencia, Date fim_vigencia) {
        this.codigo = codigo;
        this.inicio_vigencia = inicioVigencia;
        this.fim_vigencia = fim_vigencia;
        this.aplicativo = aplicativo;
        this.cliente = cliente;

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

    public Date getInicio_vigencia() {
        return inicio_vigencia;
    }

    public void setInicio_vigencia(Date inicio_vigencia) {
        this.inicio_vigencia = inicio_vigencia;
    }

    public Date getFim_vigencia() {
        return fim_vigencia;
    }

    public void setFim_vigencia(Date fimVigencia) {
        this.fim_vigencia = fimVigencia;
    }
}
