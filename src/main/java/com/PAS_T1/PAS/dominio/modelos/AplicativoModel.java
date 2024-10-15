package com.PAS_T1.PAS.dominio.modelos;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class AplicativoModel {
    @Id
    @GeneratedValue
    private long codigo;
    private String nome;
    private double custoMensal;


    public AplicativoModel(long codigo, String nome, double custoMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public long getCodigo() {
        return codigo;
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

    @Override
    public String toString() {
        return "AplicativoModel{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", custoMensal=" + custoMensal +
                '}';
    }
}
