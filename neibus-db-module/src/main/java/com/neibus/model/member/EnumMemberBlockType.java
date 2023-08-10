package com.neibus.model.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumMemberBlockType {

	MBT01("추천인 코드 불법 이용"),
	MBT02("커뮤니티 불량 이용자 신고 접수"),
	MBT03("챌린지 불량 이용자 신고 접수"),
	MBT04("계정 명의 도용");

	private final String description;
}
