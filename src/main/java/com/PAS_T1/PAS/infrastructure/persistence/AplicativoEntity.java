package com.PAS_T1.PAS.infrastructure.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "aplicativo") // Define o nome da tabela no banco de dados
public class AplicativoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "custo_mensal", nullable = false)
    private double custoMensal;

    // Construtor vazio para JPA
    public AplicativoEntity() {}

    // Construtor com parâmetros
    public AplicativoEntity( String nome, double custoMensal) {
        this.id = id;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
