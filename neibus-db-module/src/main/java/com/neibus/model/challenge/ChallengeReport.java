package com.neibus.challenge.model;

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
public class ChallengeReport {

	@Getter
	@AllArgsConstructor
	public enum ReportType {
		INVALID_POLICY("챌린지 인증 정책에 맞지 않은 사진이에요."),
		AD("광고/홍보 사진이에요."),
		ABUSE("욕설/비방 사진이에요."),
		PORN("음란물 사진이에요."),
		DEATH_MATCH("집단간 싸움을 유발하는 글과 사진이에요."),
		PRIVACY("개인정보가 노출된 글이에요."),
		;

		private String desc;
	}

	private Long reportId;
	private Integer memberIdx;
	private Long certificationId;
	private ReportType reportType;
	private LocalDateTime createdAt;
}
