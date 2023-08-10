package com.neibus.model.member;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorCode implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int code;
	private String errorMsg;
}
