package com.PAS_T1.PAS.dominio.modelos;


import java.util.Date;

public class PagamentoModel {
    long id;
    private AssinaturaModel assinatura;
    private double valor;
    private Date dataPagamento;
    private String promocao;

    public PagamentoModel(long id, AssinaturaModel assinatura, double valor, Date dataPagamento, String promocao) {
        this.id = id;
        this.assinatura = assinatura;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public long getId() {
        return id;
    }

    public AssinaturaModel getAssinatura() {
        return assinatura;
    }

    public double getValor() {
        return valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }
}
