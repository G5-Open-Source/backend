package com.upc.becodebackend.user.infrastructure.persistence;

import com.upc.becodebackend.user.domain.entities.Subscription;
import com.upc.becodebackend.user.domain.repositories.SubscriptionRepository;
import com.upc.becodebackend.user.infrastructure.persistence.models.SubscriptionEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaSubscriptionRepository implements SubscriptionRepository {

    private final SubscriptionJpaRepository jpaRepository;

    public JpaSubscriptionRepository(SubscriptionJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Subscription save(Subscription subscription) {
        SubscriptionEntity entity = new SubscriptionEntity(subscription);
        SubscriptionEntity savedEntity = jpaRepository.save(entity);
        return savedEntity.toDomain();
    }

    @Override
    public Subscription findByUserId(String userId) {
        Optional<SubscriptionEntity> entityOptional = Optional.ofNullable(jpaRepository.findByUserId(userId));
        return entityOptional.map(SubscriptionEntity::toDomain).orElse(null);
    }
}
