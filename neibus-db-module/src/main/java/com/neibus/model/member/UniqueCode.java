package com.neibus.model.member;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UniqueCode implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idx;
	private String code;
	private String type;
	private String useYn;
	private String regDt;
	private int maxIdx;
	private int endRow;
}
