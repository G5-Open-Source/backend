package com.upc.becodebackend.user.interfaces.rest;

import com.upc.becodebackend.user.application.usecases.SubscribeUserUseCase;
import com.upc.becodebackend.user.domain.entities.Subscription;
import com.upc.becodebackend.user.domain.valueobjects.TipoSuscripcion;
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
