package com.neibus.model.advertisement;

import lombok.Getter;

@Getter
public enum CategoryType {
	FIT_DEFAULT("정류장핏(일반형)"),
	FIT_MISSION("정류장핏(미션형)"),
	CHALLENGE("챌린지"),
	ETC("기타")
	;

	private String name;

	CategoryType(String name) {
		this.name = name;
	}
}
