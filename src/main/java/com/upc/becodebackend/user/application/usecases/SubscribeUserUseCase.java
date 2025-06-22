package com.upc.becodebackend.user.application.usecases;

import com.upc.becodebackend.user.domain.entities.Subscription;
import com.upc.becodebackend.user.domain.repositories.SubscriptionRepository;
import com.upc.becodebackend.user.domain.valueobjects.TipoSuscripcion;

public class SubscribeUserUseCase {

    private final SubscriptionRepository subscriptionRepository;

    public SubscribeUserUseCase(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription subscribeUser(String userId, TipoSuscripcion tipoSuscripcion) {
        Subscription subscription = new Subscription(userId, tipoSuscripcion);
        return subscriptionRepository.save(subscription);
    }
}
