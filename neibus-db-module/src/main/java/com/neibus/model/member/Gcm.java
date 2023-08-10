package com.neibus.model.member;

import java.io.Serializable;

import com.neibus.common.util.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Gcm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String regId;
	private String os;
	private String adId;
	private String regDt;
	private String noticeFlag;
	private String eventFlag;
	private String tokenFlag;
	private String communityFlag;
	private String couponFlag;
	private String advertiseFlag;
	private Member member;

	public String getRegDt() {
		return DateUtil.changeDateFormat(regDt, DateUtil.DEFAULT_FORMAT);
	}

	public Member instanceMember() {
		if (member == null)
			member = new Member();
		return member;
	}

	public Gcm(int memberIdx) {
		this.member = new Member(memberIdx);
	}
}
