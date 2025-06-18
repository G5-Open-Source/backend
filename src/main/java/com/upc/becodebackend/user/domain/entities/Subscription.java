package com.upc.becodebackend.user.domain.entities;

import com.upc.becodebackend.user.domain.valueobjects.TipoSuscripcion;

public class Subscription {
    private Long id;
    private String userId;
    private TipoSuscripcion tipoSuscripcion;

    public Subscription(Long id, String userId, TipoSuscripcion tipoSuscripcion) {
        this.id = id;
        this.userId = userId;
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public Subscription(String userId, TipoSuscripcion tipoSuscripcion) {
        this.id = null;
        this.userId = userId;
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public Long getId() { return id; }
    public String getUserId() { return userId; }
    public TipoSuscripcion getTipoSuscripcion() { return tipoSuscripcion; }
}
