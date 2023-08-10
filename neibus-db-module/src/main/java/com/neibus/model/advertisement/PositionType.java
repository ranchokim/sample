package com.neibus.model.advertisement;

import lombok.Getter;

@Getter
public enum PositionType {
	HOME("시작(홈)"),
	EXIT("종료"),
	ROULETTE("출석 룰렛"),
	TOKEN_SAVING("토큰 적립(홈)"),
	EVENT("응모")
	;

	private String name;

	PositionType(String name) {
		this.name = name;
	}
}
