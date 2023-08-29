package withchat.domain.member.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import withchat.domain.member.dto.Member;

@Mapper
public interface MemberMapper {
	public Member login(@Param("id") String id, @Param("password") String password);
}
