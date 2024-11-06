package br.com.dev.api_service.websocket.chat;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    List<ChatMessage> findByChatId(String chatId);
    List<ChatMessage> findBySenderIdAndRecipientId(String senderId, String recipientId);
    List<ChatMessage> findByRecipientId(String recipientId);
}
