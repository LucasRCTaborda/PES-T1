package com.PAS_T1.PAS.infrastructure.persistence;


import jakarta.persistence.*;

@Entity
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private AssinaturaEntity assinaturaEntity;

    private double valor_pago;
    private String promocao;

    public PagamentoEntity() {
    }

    public PagamentoEntity(long codigo, AssinaturaEntity assinaturaEntity, double valorPago, String promocao) {
        this.codigo = codigo;
        this.assinaturaEntity = assinaturaEntity;
        this.valor_pago = valorPago;
        this.promocao = promocao;
    }

    public long getCodigo() {
        return codigo;
    }

    public AssinaturaEntity getAssinatura() {
        return assinaturaEntity;
    }

    public void setAssinatura(AssinaturaEntity assinaturaEntity) {
        this.assinaturaEntity = assinaturaEntity;
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
                ", assinatura=" + assinaturaEntity +
                ", valorPago=" + valor_pago +
                ", promocao='" + promocao + '\'' +
                '}';
    }


}
