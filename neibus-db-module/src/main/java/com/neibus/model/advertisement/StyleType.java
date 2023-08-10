package com.neibus.model.advertisement;

import lombok.Getter;

@Getter
public enum StyleType {
	BOTTOM_SHEET("바텀 시트"),
	FULL_SCREEN("전면 팝업"),
	LAYER("레이어 팝업")
	;

	private String name;

	StyleType(String name) {
		this.name = name;
	}
}
