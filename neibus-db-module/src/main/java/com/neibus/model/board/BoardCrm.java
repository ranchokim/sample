package com.neibus.model.board;

import static com.neibus.board.model.Status.*;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCrm {

	private int idx;
	private LocalDateTime regDate;
	private BoardType boardType;
	private ContentType contentType;
	private String content;
	private String status;

	public Status getStatus() {
		if (status.equals("N")) {
			return D;
		}

		return Status.valueOf(status);
	}
}
