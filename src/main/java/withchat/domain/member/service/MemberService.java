package withchat.domain.member.service;

import withchat.domain.member.dto.Member;

public interface MemberService {
	public Member login(String id, String password);
}
