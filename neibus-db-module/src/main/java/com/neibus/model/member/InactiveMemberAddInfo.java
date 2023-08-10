package com.neibus.model.member;

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
public class InactiveMemberAddInfo {

	enum Status {HOLD, RESTORED}

	private Integer id;
	private Integer memberIdx;
	private Integer targetIdx;
	private String userNm;
	private String mobileNo;
	private String email;
	private String address;
	private String category;
	private String regDt;
	private Status status;

	public InactiveMemberAddInfo(MemberAddInfo memberAddInfo) {
		this.memberIdx = memberAddInfo.getMemberIdx();
		this.targetIdx = memberAddInfo.getTargetIdx();
		this.userNm = memberAddInfo.getUserNm();
		this.mobileNo = memberAddInfo.getMobileNo();
		this.email = memberAddInfo.getEmail();
		this.address = memberAddInfo.getAddress();
	}
}
