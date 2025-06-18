package com.vecihub.subscription.interfaces.rest;

import com.vecihub.subscription.application.usecases.SubscribeUserUseCase;
import com.vecihub.subscription.domain.entities.Subscription;
import com.vecihub.subscription.domain.valueobjects.TipoSuscripcion;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscribeUserUseCase subscribeUserUseCase;

    public SubscriptionController(SubscribeUserUseCase subscribeUserUseCase) {
        this.subscribeUserUseCase = subscribeUserUseCase;
    }

    @PostMapping
    public Subscription subscribe(@RequestParam String userId, @RequestParam TipoSuscripcion tipo) {
        return subscribeUserUseCase.subscribeUser(userId, tipo);
    }
}