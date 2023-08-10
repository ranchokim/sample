package com.neibus.model.banner;

import lombok.Getter;

@Getter
public enum DomainType implements EnumType {

	HOME("홈"),
	MYTOKEN("마이네이토큰"),
	COMMUNITY("커뮤니티"),
	ROULETTE("출석체크"),
	ENTRY("응모"),
	MARKET("마켓"),
	COUPON("쿠폰"),
	NOTICE("공지사항"),
	FAQ("FAQ"),
	CUSTOMERCENTER("고객센터"),
	ALERT("알림"),
	BUS("버스"),
	SUBWAY("지하철"),
	CHALLENGE("친환경챌린지"),
	QUIZ("정류장퀴즈"),
	DROP("정류장드롭"),
	PM("자전거"),
	;

	private String value;

	DomainType(String value) {
		this.value = value;
	}

	@Override
	public String getCode() {
		return name();
	}
}
