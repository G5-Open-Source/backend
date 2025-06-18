package com.vecihub.subscription.infrastructure.persistence.models;

import com.vecihub.subscription.domain.entities.Subscription;
import com.vecihub.subscription.domain.valueobjects.TipoSuscripcion;
import jakarta.persistence.*;

@Entity
@Table(name = "subscriptions")
public class SubscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String tipoSuscripcion;

    // Constructor vacío para JPA
    public SubscriptionEntity() {}

    // Constructor que recibe Subscription del dominio
    public SubscriptionEntity(Subscription subscription) {
        this.id = subscription.getId();
        this.userId = subscription.getUserId();
        this.tipoSuscripcion = subscription.getTipoSuscripcion().getValue();
    }

    // Convierte la entidad JPA a dominio
    public Subscription toDomain() {
        return new Subscription(this.id, this.userId, new TipoSuscripcion(this.tipoSuscripcion));
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getTipoSuscripcion() { return tipoSuscripcion; }
    public void setTipoSuscripcion(String tipoSuscripcion) { this.tipoSuscripcion = tipoSuscripcion; }
}