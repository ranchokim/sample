package com.neibus.model.member;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tester {

	private Long id;
	private String name;
	private String ci;
	private LocalDateTime regDt;
}
