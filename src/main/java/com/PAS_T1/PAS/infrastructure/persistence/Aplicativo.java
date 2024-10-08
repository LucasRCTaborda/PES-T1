package com.PAS_T1.PAS.infrastructure.persistence;


import jakarta.persistence.*;
@Table
@Entity
public class Aplicativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long ID;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "custoMensal", nullable = false)
    private double custo_mensal;

    public Aplicativo() {
    }

    public Aplicativo(Long codigo, String nome, double custo_mensal) {
        this.ID = codigo;
        this.nome = nome;
        this.custo_mensal = custo_mensal;
    }

    public Long getCodigo() {
        return ID;
    }

    public void setCodigo(Long codigo) {
        this.ID = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCusto_mensal() {
        return custo_mensal;
    }

    public void setCusto_mensal(double custoMensal) {
        this.custo_mensal = custoMensal;
    }
/*
    public static Aplicativo fromAplicativoModel(AplicativoModel apModel) {
        return new Aplicativo(apModel.getCodigo(), apModel.getNome(), apModel.getCustoMensal());
    }

    public static AplicativoModel toAplicativoModel(Aplicativo aplicativo) {
        return new AplicativoModel(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCusto_mensal());
    }*/
}
