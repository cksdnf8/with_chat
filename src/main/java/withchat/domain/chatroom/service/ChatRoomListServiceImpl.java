package withchat.domain.chatroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import withchat.domain.chatroom.dto.ChatRoomList;
import withchat.domain.chatroom.mapper.ChatRoomListMapper;

@Service
public class ChatRoomListServiceImpl implements ChatRoomListService{
	
	@Autowired
	ChatRoomListMapper chatRoomListMapper;
	
	@Override
	public List<ChatRoomList> chatroomlist(){
		List<ChatRoomList> chatRoomList = chatRoomListMapper.chatroomlist();
		return chatRoomList;
	};
}
