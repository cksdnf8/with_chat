package withchat.domain.member.dto;

import lombok.Data;
import withchat.domain.member.dto.Member;

@Data
public class Member {
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String gender;
	private int age;
}
