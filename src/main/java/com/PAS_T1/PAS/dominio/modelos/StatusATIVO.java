package com.PAS_T1.PAS.dominio.modelos;

public enum StatusATIVO {
    ATIVO(1),
    CANCELADO(2),
    TODAS(3) ;

    private int code;

    private StatusATIVO(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static StatusATIVO valueOf(int code) {
        for (StatusATIVO value : StatusATIVO.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}