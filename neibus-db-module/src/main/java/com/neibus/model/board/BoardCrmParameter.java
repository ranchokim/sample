package com.neibus.model.board;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BoardCrmParameter {

	private int memberIdx;
	private LocalDate startRegDate;
	private LocalDate endRegDate;
	private BoardType boardType;
	private ContentType contentType;
	private Status status;
}
