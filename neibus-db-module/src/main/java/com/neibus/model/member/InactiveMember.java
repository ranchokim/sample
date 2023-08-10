package com.neibus.model.member;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InactiveMember {

	enum Status {HOLD, RESTORED}

	private Integer id;
	private Integer memberIdx;
	private String email;
	private String nick;
	private String name;
	private String birthday;
	private String sex;
	private String ci;
	private String ci2;
	private String telComCd;
	private String ciUpdate;
	private String ntvFrnrCd;
	private String accessToken;
	private String mobileNo;
	private String mdLinkStatus;
	private String myDataUser;
	private String regDt;
	private Status status;
	private LocalDateTime holdDt;
	private LocalDateTime restoredDt;

	public InactiveMember(Member member) {
		this.memberIdx = member.getIdx();
		this.email = member.getEmail();
		this.nick = member.getNick();
		this.name = member.getName();
		this.birthday = member.getBirthday();
		this.sex = member.getSex();
		this.ci = member.getCi();
		this.ci2 = member.getCi2();
		this.telComCd = member.getTelComCd();
		this.ciUpdate = member.getCiUpdate();
		this.ntvFrnrCd = member.getNtvFrnrCd();
		this.accessToken = member.getAccessToken();
		this.mobileNo = member.getMobileNo();
		this.mdLinkStatus = member.getMdLinkStatus();
		this.myDataUser = member.getMydataUser();
		this.regDt = member.getRegDt();
	}
}
