package withchat.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import withchat.domain.chatroom.dto.ChatDTO;
import withchat.domain.chatroom.dto.ChatRoom;
import withchat.domain.chatroom.service.ChatService;

@Slf4j
@RequiredArgsConstructor
@Component
public class WithchatHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper;
    private final ChatService chatService;
    
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	String payload = message.getPayload();
    	log.info("{}", payload);
    	
    	ChatDTO chatMessage = objectMapper.readValue(payload, ChatDTO.class);
    	
    }
    
}