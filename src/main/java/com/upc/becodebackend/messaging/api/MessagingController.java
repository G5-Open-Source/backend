package com.upc.becodebackend.messaging.api;

import com.upc.becodebackend.messaging.application.services.MessagingService;
import com.upc.becodebackend.messaging.domain.model.Message;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessagingController {
    private final MessagingService messagingService;

    public MessagingController(MessagingService messagingService) {
        this.messagingService = messagingService;
    }

    @GetMapping("/{userId}")
    public List<Message> getMessages(@PathVariable Long userId) {
        return messagingService.getMessagesForUser(userId);
    }

    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        return messagingService.sendMessage(message);
    }
}
