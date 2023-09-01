package withchat.domain.member.service;

import org.apache.ibatis.annotations.Param;

import withchat.domain.member.dto.Member;

public interface MemberService {
	public Member login(String id, String password);
	
	public void registMember(String id, String password, String name, String nickname, String gender, int age);
}
