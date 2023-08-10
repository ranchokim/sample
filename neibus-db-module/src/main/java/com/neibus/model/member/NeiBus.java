package com.neibus.model.member;

import java.io.Serializable;

import com.neibus.common.domain.Paging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NeiBus implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idx;
	private String type;
	private String routeId;
	private String city;
	private String area;
	private String busNo;
	private String busNoTitle;
	private String busNoSubTitle;
	private String busCompany;
	private String startPoint;
	private String endPoint;
	private String turning;
	private String startTime;
	private String endTime;
	private String startTime2;
	private String endTime2;
	private String weekdaysTerm;
	private String weekendTerm;
	private String holidayTerm;
	private String keyword;
	private Paging paging;
	private String stationOrder;
	private String cityCode;
}