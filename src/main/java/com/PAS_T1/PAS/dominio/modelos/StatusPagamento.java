package com.PAS_T1.PAS.dominio.modelos;

public enum StatusPagamento {
    PAGAMENTO_OK(1),
    VALOR_INCORRETO(2),
    CANCELED(3);

    private int code;

    private StatusPagamento(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static StatusPagamento valueOf(int code) {
        for (StatusPagamento value : StatusPagamento.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}