package com.neibus.model.stationfit.crm;

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
public class NeiBusStopInfo {

	private Integer idx;
	private String area;
	private String mobileNo;
	private String stationName;
}
