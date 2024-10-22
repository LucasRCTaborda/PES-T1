package com.PAS_T1.PAS.dominio.modelos;

import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Aplicativo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;


public class AplicativoModel {
    private long id;
    private String nome;
    private double custoMensal;

    protected AplicativoModel() {}

    public AplicativoModel(long id, String nome, double custoMensal) {
        this.id = id;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public static AplicativoModel fromAplicativo(Aplicativo aplicativo) {
        return new AplicativoModel(
                aplicativo.getId(),
                aplicativo.getNome(),
                aplicativo.getCustoMensal()
        );
    }
    public static Aplicativo toAplicativo(AplicativoModel aplicativoModel) {
        return new Aplicativo(
                aplicativoModel.getId(),
                aplicativoModel.getNome(),
                aplicativoModel.getCustoMensal()
        );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCustoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(double custoMensal) {
        this.custoMensal = custoMensal;
    }
}