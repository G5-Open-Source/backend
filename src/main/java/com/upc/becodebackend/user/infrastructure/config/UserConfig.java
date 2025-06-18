package com.upc.becodebackend.user.infrastructure.config;

import com.upc.becodebackend.user.application.usecases.SubscribeUserUseCase;
import com.upc.becodebackend.user.domain.repositories.SubscriptionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public SubscribeUserUseCase subscribeUserUseCase(SubscriptionRepository subscriptionRepository) {
        return new SubscribeUserUseCase(subscriptionRepository);
    }
}
