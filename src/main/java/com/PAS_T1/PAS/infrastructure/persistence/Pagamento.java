package com.PAS_T1.PAS.infrastructure.persistence;


import jakarta.persistence.*;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Assinatura assinatura;

    private double valor_pago;
    private String promocao;

    public Pagamento() {
    }

    public Pagamento(long codigo, Assinatura assinatura, double valorPago, String promocao) {
        this.codigo = codigo;
        this.assinatura = assinatura;
        this.valor_pago = valorPago;
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

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valorPago) {
        this.valor_pago = valorPago;
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
                ", valorPago=" + valor_pago +
                ", promocao='" + promocao + '\'' +
                '}';
    }


}
