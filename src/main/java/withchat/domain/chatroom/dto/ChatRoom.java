package withchat.domain.chatroom.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.WebSocketSession;

import lombok.Builder;
import lombok.Data;
import withchat.domain.chatroom.service.ChatService;

@Data
public class ChatRoom {
	private String roomid;
	private String name;
	private Set<WebSocketSession> sessions = new HashSet<>();
	
	@Builder
	public ChatRoom(String roomid, String name) {
		this.roomid = roomid;
		this.name = name;
	}
	
	public void handleAction(WebSocketSession session, ChatDTO message, ChatService service) {
		// message 에 담긴 타입을 확인한다.
        // 이때 message 에서 getType 으로 가져온 내용이
        // ChatDTO 의 열거형인 MessageType 안에 있는 ENTER 과 동일한 값인 경우
		// session 에 넘어온 session을 담는다.
		if(message.getType().equals(ChatDTO.MessageType.ENTER)) {
			sessions.add(session);
			message.setMessage(message.getId() + "님이 입장하셨습니다.");
			
		}
		
	}
	
}
