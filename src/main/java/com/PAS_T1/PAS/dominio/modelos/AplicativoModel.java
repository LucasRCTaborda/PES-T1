package com.PAS_T1.PAS.dominio.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;


public class AplicativoModel {

    @Id
    private long codigo;

    private String nome;

    // Mapeamento correto da coluna "CUSTOMENSAL" no banco de dados
    @Column(name = "CUSTOMENSAL")
    private double custoMensal;

    // Construtor padrão (obrigatório para JPA)
    public AplicativoModel() {
    }

    // Construtor com parâmetros
    public AplicativoModel(long codigo, String nome, double custoMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    // Getters e setters
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
