package com.vecihub.subscription.infrastructure.persistence;

import com.vecihub.subscription.infrastructure.persistence.models.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionJpaRepository extends JpaRepository<SubscriptionEntity, Long> {
    SubscriptionEntity findByUserId(String userId);
}