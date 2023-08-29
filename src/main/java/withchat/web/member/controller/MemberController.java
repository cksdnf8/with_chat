package withchat.web.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import withchat.domain.chatroom.dto.ChatRoomList;
import withchat.domain.chatroom.service.ChatRoomListService;
import withchat.domain.member.dto.Member;
import withchat.domain.member.service.MemberService;
import withchat.web.member.controller.MemberController;

@Controller
@Slf4j
public class MemberController {

	@Autowired MemberService memberService;
	@Autowired ChatRoomListService chatRoomListService;
	
	@RequestMapping(value = "/withchat")
	  public String home() {
	    return "/main.html";
	  }
	
	@PostMapping("/login")
	public String login(@RequestParam String id, @RequestParam String password, Model model) {
		Member member = memberService.login(id, password);
		List<ChatRoomList> list = chatRoomListService.chatroomlist();
		if(member != null) {
			model.addAttribute("nickname", member.getNickname());
			model.addAttribute("list", list);
			return "waitingRoom";
		}else {
			return "main";
		}
	}
	
}
