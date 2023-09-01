package withchat.web.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	// 로그인
	@PostMapping("/login")
	public String login(@RequestParam String id, @RequestParam String password, Model model, HttpSession session) {
		Member member = memberService.login(id, password);
		List<ChatRoomList> list = chatRoomListService.chatroomlist();
		if(member != null) {
			model.addAttribute("nickname", member.getNickname());
			model.addAttribute("list", list);
			session.setAttribute("member", member);
			return "waitingRoom";
		}else {
			return "main";
		}
	}
	
	// 회원가입 버튼
	@PostMapping("/join")
	public String join() {
		return "regist";
	}
	
	// 회원가입 완료 후 등록
	@PostMapping("/registMember")
	public String registMember(
			@RequestParam String id, 
			@RequestParam String password, 
			@RequestParam String name, 
			@RequestParam String nickName,
			@RequestParam int age,
			HttpServletRequest request) {
		String gender = request.getParameter("selectGender");
		if(gender.equals("남")) {
			gender = "M";
		}else {
			gender = "W";
		}
		memberService.registMember(id, password, name, nickName, gender, age);
		
		return "main";
	}
	
	
}
