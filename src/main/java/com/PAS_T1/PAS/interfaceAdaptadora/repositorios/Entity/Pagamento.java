package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity;


import com.PAS_T1.PAS.dominio.modelos.PagamentoModel;
import jakarta.persistence.*;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Assinatura assinatura;

    private double valorPago;
    private String promocao;

    public Pagamento() {
    }

    public Pagamento(long codigo, Assinatura assinatura, double valorPago, String promocao) {
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
        return "Pagamento{" +
                "codigo=" + codigo +
                ", assinatura=" + assinatura +
                ", valorPago=" + valorPago +
                ", promocao='" + promocao + '\'' +
                '}';
    }

    public static Pagamento fromPagamentoModel(PagamentoModel pModel) {
        Assinatura assinatura = null;
        return new Pagamento(pModel.getCodigo(), assinatura, pModel.getValorPago(), pModel.getPromocao());
    }

    public static PagamentoModel toPagamentoModel(Pagamento pagamento) {
        return new PagamentoModel(pagamento.getCodigo(), pagamento.getAssinatura(), pagamento.getValorPago(), pagamento.getPromocao());
    }
}
