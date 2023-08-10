package com.neibus.challenge.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neibus.challenge.model.json.certification.Information;
import com.neibus.member.model.Member;
import com.neibus.member.model.MemberReport;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Certification {
	public enum State {COMPLETE, REJECT, DELETE}

	private Long certificationId;
	private Long challengeId;
	private Integer memberId;
	private Information information;
	private String memo;
	private State state;
	private Boolean visible;
	private String rejectMsg;
	private LocalDateTime createdAt;
	private String certificatedAt;
	private Long like;
	private Member member;
	private ChallengeReport challengeReport;
	private MemberReport memberReport;

	@Builder
	public Certification(Long challengeId, int memberId, Information info, String memo, String certificatedAt) {
		this.challengeId = challengeId;
		this.memberId = memberId;
		this.information = info;
		this.memo = memo;
		this.state = State.COMPLETE;
		this.certificatedAt = certificatedAt;
	}

	@JsonIgnore
	public boolean isReport() {
		return challengeReport != null;
	}

	@JsonIgnore
	public boolean isReportedMember() {
		return memberReport != null;
	}

	public String buildReportMessage(int memberIdx, String reportDesc) {
		return String.format("챌린지: %d\n", challengeId)
				+ String.format("게시자: %s(%d)\n", member.getNick(), member.getIdx())
				+ String.format("신고자: (%d)\n", memberIdx)
				+ String.format("신고사유: %s\n", reportDesc);
	}

	public boolean isSuccess() {
		return state == State.COMPLETE;
	}

	public boolean isFail() {
		return state == State.REJECT;
	}
}
