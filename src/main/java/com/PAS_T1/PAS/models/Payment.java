package com.PAS_T1.PAS.models;


import jakarta.persistence.*;

@Entity
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Subscription subscription;

    private double valorPago;
    private String promocao;

    public Payment() {
    }

    public Payment(long codigo, Subscription subscription, double valorPago, String promocao) {
        this.codigo = codigo;
        this.subscription = subscription;
        this.valorPago = valorPago;
        this.promocao = promocao;
    }

    public long getCodigo() {
        return codigo;
    }

    public Subscription getAssinatura() {
        return subscription;
    }

    public void setAssinatura(Subscription subscription) {
        this.subscription = subscription;
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
                ", assinatura=" + subscription +
                ", valorPago=" + valorPago +
                ", promocao='" + promocao + '\'' +
                '}';
    }


}
