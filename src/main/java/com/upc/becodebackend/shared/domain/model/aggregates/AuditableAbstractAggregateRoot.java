package com.upc.becodebackend.shared.domain.model.aggregates;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass

public class AuditableAbstractAggregateRoot<T extends AbstractAggregateRoot<T>> extends AbstractAggregateRoot<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Getter
    @CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = "DATETIME")
    private Date createdAt;

    @Getter
    @LastModifiedDate
    @Column(nullable = false, columnDefinition = "DATETIME")
    private Date updatedAt;
    
    @Getter
    @Setter
    @Column(nullable = false)
    private Boolean active = true;

    protected AuditableAbstractAggregateRoot() {
        this.active = true;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public boolean isActive() {
        return this.active != null ? this.active : true;
    }

    public boolean isInactive() {
        return !isActive();
    }

    public boolean isDeleted() {
        return !isActive();
    }

    public void markAsDeleted() {
        this.active = false;
    }

    public void restore() {
        this.active = true;
    }
    public String getId() {
    return this.id;
    }
}
