package com.upc.becodebackend.user.domain.repositories;

import com.upc.becodebackend.user.domain.entities.Subscription;

public interface SubscriptionRepository {
    Subscription save(Subscription subscription);
    Subscription findByUserId(String userId);
}
