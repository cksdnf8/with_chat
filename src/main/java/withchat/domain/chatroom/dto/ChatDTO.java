package withchat.domain.chatroom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatDTO {

	public enum MessageType{
		ENTER, TALK, LEAVE;
	}
	
	private MessageType type;
	private String roomnum;
	private String id;
	private String message;
	private String time;
}
