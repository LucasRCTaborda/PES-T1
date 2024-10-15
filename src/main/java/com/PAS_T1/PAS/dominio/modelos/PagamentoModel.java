package com.PAS_T1.PAS.dominio.modelos;


import com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity.Assinatura;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class PagamentoModel {


    @Id
    @GeneratedValue
    private long codigo;
    private Assinatura assinatura;
    private double valorPago;
    private String promocao;

    public PagamentoModel(long codigo, Assinatura assinatura, double valorPago, String promocao) {
        this.codigo = codigo;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.promocao = promocao;
    }

    public long getCodigo() {
        return codigo;
    }


    public Assinatura getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(Assinatura assinatura) {
        this.assinatura = assinatura;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getPromocao() {
        return promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    @Override
    public String toString() {
        return "PagamentoModel{" +
                "codigo=" + codigo +
                ", assinatura=" + assinatura +
                ", valorPago=" + valorPago +
                ", promocao='" + promocao + '\'' +
                '}';
    }
}
