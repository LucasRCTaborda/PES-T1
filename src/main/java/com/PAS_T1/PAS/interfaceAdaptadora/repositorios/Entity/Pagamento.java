package com.PAS_T1.PAS.interfaceAdaptadora.repositorios.Entity;


import com.PAS_T1.PAS.dominio.modelos.PagamentoModel;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pagamentos")
public class Pagamento {
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "assinatura_id")
    private Assinatura assinatura;
    private double valor;
    private Date dataPagamento;
    private String promocao;

    protected Pagamento() {}

    public Pagamento(long id, Assinatura assinatura, double valor, Date dataPagamento, String promocao) {
        this.id = id;
        this.assinatura = assinatura;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public long getId() {
        return id;
    }

    public Assinatura getAssinatura() {
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

    public static PagamentoModel toPagamentoModel(Pagamento pagamento) {
        return new PagamentoModel(
                pagamento.getId(),
                Assinatura.toAssinaturaModel(pagamento.getAssinatura()),
                pagamento.getValor(),
                pagamento.getDataPagamento(),
                pagamento.getPromocao()

        );
    }

    public static Pagamento fromPagamentomodel(PagamentoModel pagamentoModel) {
        return new Pagamento(
                pagamentoModel.getId(),
                Assinatura.fromAssinaturaModel(pagamentoModel.getAssinatura()),
                pagamentoModel.getValor(),
                pagamentoModel.getDataPagamento(),
                pagamentoModel.getPromocao()
        );
    }
}
