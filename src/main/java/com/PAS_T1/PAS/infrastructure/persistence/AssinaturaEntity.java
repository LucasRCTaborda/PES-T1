package com.PAS_T1.PAS.infrastructure.persistence;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class AssinaturaEntity {

    @Id
    @GeneratedValue


    private long codigo;
    @Column(name = "Inicio_Vigencia", nullable = false)
    private Date inicio_vigencia;
    @Column(name = "Fim_Vigencia", nullable = false)
    private Date fim_vigencia;
    @ManyToOne
    private AplicativoEntity aplicativoEntity;

    @ManyToOne
    private ClienteEntity clienteEntity;





    public AssinaturaEntity() {

    }



    public AssinaturaEntity(long codigo, AplicativoEntity aplicativoEntity, ClienteEntity clienteEntity, Date inicioVigencia, Date fim_vigencia) {
        this.codigo = codigo;
        this.inicio_vigencia = inicioVigencia;
        this.fim_vigencia = fim_vigencia;
        this.aplicativoEntity = aplicativoEntity;
        this.clienteEntity = clienteEntity;

    }

    // Getters e Setters
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public AplicativoEntity getAplicativo() {
        return aplicativoEntity;
    }

    public void setAplicativo(AplicativoEntity aplicativoEntity) {
        this.aplicativoEntity = aplicativoEntity;
    }

    public ClienteEntity getCliente() {
        return clienteEntity;
    }

    public void setCliente(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
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
