package com.vecihub.subscription.domain.valueobjects;

public class TipoSuscripcion {
    private final String value;

    public TipoSuscripcion(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}