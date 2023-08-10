package com.neibus.model.board;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BoardCrmStatistics {

	private int communityPostCount;
	private int communityCommentCount;
	private int reviewPostCount;
	private int reviewCommentCount;
	private int totalCount;
}
