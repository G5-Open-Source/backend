package com.upc.becodebackend.user.infrastructure.persistence;

import com.upc.becodebackend.user.infrastructure.persistence.models.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionJpaRepository extends JpaRepository<SubscriptionEntity, Long> {
    SubscriptionEntity findByUserId(String userId);
}
