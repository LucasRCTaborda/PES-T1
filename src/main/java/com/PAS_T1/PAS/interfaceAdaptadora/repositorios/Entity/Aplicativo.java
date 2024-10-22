package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity;


import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "aplicativos")
public class Aplicativo {
    @Id
    private long id;
    private String nome;
    private double custoMensal;

    protected Aplicativo() {}

    public Aplicativo(long id, String nome, double custoMensal) {
        this.id = id;
        this.nome = nome;
        this.custoMensal = custoMensal;
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

    public static AplicativoModel toAplicativoModel(Aplicativo aplicativo) {
        return new AplicativoModel(
                aplicativo.getId(),
                aplicativo.getNome(),
                aplicativo.custoMensal
        );
    }

    public static Aplicativo fromAplicativoModel(AplicativoModel aplicativoModel) {
        return new Aplicativo(
                aplicativoModel.getId(),
                aplicativoModel.getNome(),
                aplicativoModel.getCustoMensal()
        );
    }
    }