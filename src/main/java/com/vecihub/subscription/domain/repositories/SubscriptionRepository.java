package com.vecihub.subscription.domain.repositories;

import com.vecihub.subscription.domain.entities.Subscription;

public interface SubscriptionRepository {
    Subscription save(Subscription subscription);
    Subscription findByUserId(String userId);
}