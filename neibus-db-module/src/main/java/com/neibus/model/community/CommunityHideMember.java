package com.neibus.model.community;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommunityHideMember {

	private Integer CommunityHideMemberId;
	private Integer memberIdx;
	private Integer hideMemberIdx;
	private LocalDateTime regDt;
	private LocalDateTime modDt;
}
