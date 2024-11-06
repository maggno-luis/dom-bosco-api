package br.com.dev.api_service.websocket.chat;

import br.com.dev.api_service.websocket.chatroom.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository repository;
    private final ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage) {
        var chatId = chatRoomService
                .getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true)
                .orElseThrow(); // You can create your own dedicated exception
        chatMessage.setChatId(chatId);
        repository.save(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        var chatId = chatRoomService.getChatRoomId(senderId, recipientId, false);
        return chatId.map(repository::findByChatId).orElse(new ArrayList<>());
    }

    public ChatMessage saveCHAT(ChatMessage chatMessage){
        return repository.save(chatMessage);
    }

    public List<ChatMessage> findChatMessagesCHAT(String senderId, String recipientId){
        return repository.findBySenderIdAndRecipientId(senderId,recipientId);
    }

    public List<ChatMessage> findChatMessagesForAdmin(String adminId){
        return repository.findByRecipientId(adminId);
    }
}
