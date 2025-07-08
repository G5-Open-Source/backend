package com.upc.becodebackend.messaging.api;

import com.upc.becodebackend.messaging.application.services.MessagingService;
import com.upc.becodebackend.messaging.api.resources.CreateMessageResource;
import com.upc.becodebackend.messaging.domain.model.Message;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public Message sendMessage(@RequestBody CreateMessageResource resource) {
        Message message = new Message(
                resource.getSenderId(),
                resource.getReceiverId(),
                resource.getContent(),
                LocalDateTime.now()
        );
        return messagingService.sendMessage(message);
    }
}
