package withchat.domain.chatroom.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import withchat.domain.chatroom.dto.ChatRoomList;

@Mapper
public interface ChatRoomListMapper {
	public List<ChatRoomList> chatroomlist();
}
