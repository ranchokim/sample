package com.neibus.model.member;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MultiCommonFile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idx;
	private int targetIdx;
	private int fileIdx;
	private String category;
	private String regDt;
}
