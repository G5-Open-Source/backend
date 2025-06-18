package com.vecihub.subscription.infrastructure.config;

import com.vecihub.subscription.application.usecases.SubscribeUserUseCase;
import com.vecihub.subscription.domain.repositories.SubscriptionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscriptionConfig {

    @Bean
    public SubscribeUserUseCase subscribeUserUseCase(SubscriptionRepository subscriptionRepository) {
        return new SubscribeUserUseCase(subscriptionRepository);
    }
}