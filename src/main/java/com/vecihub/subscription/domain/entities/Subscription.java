package com.vecihub.subscription.domain.entities;

import com.vecihub.subscription.domain.valueobjects.TipoSuscripcion;

public class Subscription {
    private Long id;
    private String userId;
    private TipoSuscripcion tipoSuscripcion;

    // Constructor con id (para entidades existentes)
    public Subscription(Long id, String userId, TipoSuscripcion tipoSuscripcion) {
        this.id = id;
        this.userId = userId;
        this.tipoSuscripcion = tipoSuscripcion;
    }

    // Constructor sin id (para nuevas suscripciones)
    public Subscription(String userId, TipoSuscripcion tipoSuscripcion) {
        this.id = null;
        this.userId = userId;
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public Long getId() { return id; }
    public String getUserId() { return userId; }
    public TipoSuscripcion getTipoSuscripcion() { return tipoSuscripcion; }
}