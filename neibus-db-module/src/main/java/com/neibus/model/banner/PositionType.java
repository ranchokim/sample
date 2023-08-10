package com.neibus.model.banner;

import lombok.Getter;

@Getter
public enum PositionType implements EnumType {

	HOME_MAIN_MIDDLE("홈-메인-중간배너"),
	HOME_MAIN_BOTTOM("홈-메인-하단배너"),
	MISSION_MAIN_TOP("미션적립-메인-상단배너"),
	CHALLENGE_MAIN_TOP("챌린지-메인-상단배너"),
	COMMUNITY_MAIN_TOP("커뮤니티-메인-상단배너"),
	MARKET_MAIN_TOP("마켓-메인-상단배너"),
	CUSTOMERCENTER_MAIN_TOP("고객센터-메인-상단배너"),
	INQUIRY_MAIN_TOP("1:1문의-메인-상단배너"),
	FAQ_MAIN_TOP("FAQ-메인-상단배너"),
	;

	private String value;

	PositionType(String value) {
		this.value = value;
	}

	@Override
	public String getCode() {
		return name();
	}
}
