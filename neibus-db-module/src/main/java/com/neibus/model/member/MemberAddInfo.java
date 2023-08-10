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
public class MemberAddInfo {

	private Integer memberIdx;
	private Integer targetIdx;
	private String userNm;
	private String mobileNo;
	private String email;
	private String address;
	private String category;
	private String regDt;

	public MemberAddInfo(InactiveMemberAddInfo addInfo) {
		this.memberIdx = addInfo.getMemberIdx();
		this.targetIdx = addInfo.getTargetIdx();
		this.userNm = addInfo.getUserNm();
		this.mobileNo = addInfo.getMobileNo();
		this.email = addInfo.getEmail();
		this.address = addInfo.getAddress();
		this.category = addInfo.getCategory();
	}
}
