package com.neibus.model.member;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IgnoreMember {

	private Integer ignoreId;
	private Integer memberIdx;
	private Integer ignoreMemberIdx;
	private String domain; // COMMUNITY, CHALLENGE (커뮤니티는 아직 COMMUNITY_HIDE_MEMBER 테이블 쓰는 중)
	private LocalDateTime createdAt;
}
