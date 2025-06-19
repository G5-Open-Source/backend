package com.upc.becodebackend.messaging.application.services;

import com.upc.becodebackend.messaging.domain.model.Message;
import com.upc.becodebackend.messaging.domain.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessagingService {
    private final MessageRepository messageRepository;

    public MessagingService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessagesForUser(Long userId) {
        return messageRepository.findBySenderIdOrReceiverId(userId, userId);
    }

    public Message sendMessage(Message message) {
        message.setTimestamp(LocalDateTime.now());
        return messageRepository.save(message);
    }
}
