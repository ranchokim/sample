package com.neibus.model.member;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PolicyV2 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String title;
	private String type;
	private String url;

	public PolicyV2() {
	}

	public PolicyV2(String title, String type, String url) {
		this.title = title;
		this.type = type;
		this.url = url;
	}
}
