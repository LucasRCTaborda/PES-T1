package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity;


import com.PAS_T1.PAS.dominio.modelos.AplicativoModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Aplicativo {
    @Id
    @GeneratedValue
    private long codigo;
    private String nome;
    private double CUSTOMENSAL;

    public Aplicativo() {
    }

    public Aplicativo(long codigo, String nome, double custoMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.CUSTOMENSAL = custoMensal;
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
        return CUSTOMENSAL;
    }

    public void setCustoMensal(double custoMensal) {
        this.CUSTOMENSAL = custoMensal;
    }

    public static Aplicativo fromAplicativoModel(AplicativoModel apModel){
        return new Aplicativo(apModel.getCodigo(),apModel.getNome(),apModel.getCustoMensal());
    }

    public static AplicativoModel toAplicativoModel(Aplicativo aplicativo){
        return new AplicativoModel(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal());
    }
}
