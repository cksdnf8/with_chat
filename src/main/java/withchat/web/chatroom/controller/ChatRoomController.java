package withchat.web.chatroom.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import withchat.domain.chatroom.dto.ChatRoom;
import withchat.domain.chatroom.service.ChatService;
import withchat.domain.member.dto.Member;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ChatRoomController {

	
	private final ChatService chatService;
	
	@GetMapping("/makeRoom")
	public String makeRoom() {
		return "makeRoom";
	}
	
	@GetMapping("/createRoom")
	public String creatRoom(@RequestParam String roomName, Model model, HttpSession session) {
		ChatRoom room = chatService.createRoom(roomName);
		model.addAttribute("roomName", room);
		
		Member member = (Member)session.getAttribute("member");
		String nickName = member.getNickname();
		model.addAttribute("member", nickName);
		return "chatRoom";
	}
	
	@GetMapping("/rooms")
	@ResponseBody
	public List<ChatRoom> room(){
		return chatService.findAllRoom();
	}
	
	
}
