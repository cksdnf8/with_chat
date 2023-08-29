package withchat.domain.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import withchat.domain.member.dto.Member;
import withchat.domain.member.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberMapper memberMapper;
	
	@Override
	public Member login(String id, String password) {
		Member member = memberMapper.login(id, password);
		return member;
	}
}
