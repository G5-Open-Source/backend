package com.vecihub.subscription.infrastructure.persistence;

import com.vecihub.subscription.domain.entities.Subscription;
import com.vecihub.subscription.domain.repositories.SubscriptionRepository;
import com.vecihub.subscription.infrastructure.persistence.models.SubscriptionEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaSubscriptionRepository implements SubscriptionRepository {

    private final SubscriptionJpaRepository jpaRepository;

    // Inyección por constructor (mejor práctica)
    public JpaSubscriptionRepository(SubscriptionJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Subscription save(Subscription subscription) {
        SubscriptionEntity entity = new SubscriptionEntity(subscription);
        // Guardar la entidad y obtener la versión persistida (por el ID generado)
        SubscriptionEntity savedEntity = jpaRepository.save(entity);
        return savedEntity.toDomain();
    }

    @Override
    public Subscription findByUserId(String userId) {
        // Suponiendo que findByUserId puede devolver null o un Optional
        Optional<SubscriptionEntity> entityOptional = Optional.ofNullable(jpaRepository.findByUserId(userId));
        return entityOptional.map(SubscriptionEntity::toDomain).orElse(null);
    }
}