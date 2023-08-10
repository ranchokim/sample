package com.neibus.model.member;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EventUniqueCode implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idx;
	private String code;
	private int targetCnt;
	private int pointManagerIdx;
	private String startDt;
	private String endDt;
	private String regDt;
}
