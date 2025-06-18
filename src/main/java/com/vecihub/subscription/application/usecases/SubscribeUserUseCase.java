package com.vecihub.subscription.application.usecases;

import com.vecihub.subscription.domain.entities.Subscription;
import com.vecihub.subscription.domain.repositories.SubscriptionRepository;
import com.vecihub.subscription.domain.valueobjects.TipoSuscripcion;

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