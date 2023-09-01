package withchat.domain.member.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import withchat.domain.member.dto.Member;

@Mapper
public interface MemberMapper {
	// 로그인
	public Member login(@Param("id") String id, @Param("password") String password);
	// 회원가입
	public void registMember(
			@Param("id") String id, 
			@Param("password") String password, 
			@Param("name") String name, 
			@Param("nickname") String nickname,
			@Param("gender") String gender, 
			@Param("age") int age);
}
