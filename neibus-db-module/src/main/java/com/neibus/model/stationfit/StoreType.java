package com.neibus.model.stationfit;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StoreType {
	CAFE("카페"),
	FOOD("음식점"),
	CONVENIENCE_STORE("편의점"),
	MART("마트"),
	HOSPITAL("병원"),
	HAIR_SHOP("헤어샵"),
	HOTEL("호텔"),
	GAS_STATION("주유소"),
	BANK("은행"),
	EVENT("이벤트"),
;

	private String name;
}
