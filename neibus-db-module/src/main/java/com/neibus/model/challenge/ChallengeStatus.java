package com.neibus.challenge.model;

import static com.neibus.common.domain.enumable.EnumErrorCode.*;

import java.time.LocalDateTime;

import com.neibus.common.exception.ClientException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChallengeStatus {

	private Long challengeStatusId;
	private Long challengeId;
	private Integer totalRecruits;
	private Integer recruited;
	private LocalDateTime createdAt;

	public boolean isRecruiting() {
		return recruited < totalRecruits;
	}

	public void increaseRecruited() {
		recruited++;
	}

	public void decreaseRecruited() {
		recruited--;
	}

	public ChallengeStatus checkJoinValidate() {
		if (!isRecruiting()) {
			throw new ClientException.Conflict(CHALLENGE_CLOSED_RECRUIT);
		}

		return this;
	}
}
