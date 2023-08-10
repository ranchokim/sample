package com.neibus.challenge.model;

import static com.neibus.common.domain.enumable.EnumErrorCode.*;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neibus.challenge.model.json.challengedbox.MyStatistics;
import com.neibus.common.exception.ClientException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChallengedBox {

	public enum Status {Y, C;}

	private Long challengedBoxId;
	private Long challengeId;
	private Integer memberId;
	private Integer fee;
	private Status status;
	private String notification;
	private MyStatistics statistics;
	private LocalDateTime createdAt;

	public ChallengedBox exit() {
		if (status == Status.C) {
			throw new ClientException.Conflict(CHALLENGE_ALREADY_EXIT);
		}

		status = Status.C;

		return this;
	}

	public ChallengedBox validate() {
		if (!isChallenger()) {
			throw new ClientException.NotFound(CHALLENGE_NOT_FOUND_RECRUIT_HISTORY);
		}

		return this;
	}

	@JsonIgnore
	public boolean isSuccess() {
		return statistics.isSuccess();
	}

	@JsonIgnore
	public boolean isChallenger() {
		return status == Status.Y;
	}

	public void throwAlreadyJoinedException() {
		throw new ClientException.Conflict(ALREADY_RECRUITED);
	}

	public void increaseSuccess() {
		statistics.increaseSuccess();
		statistics.calcProgress();
	}

	public void reject() {
		statistics.decreaseSuccess();
		statistics.increaseFail();
		statistics.calcProgress();
	}

	public int calcTotalReward() {
		return statistics.getRewardToken() + fee;
	}

	public void deleteSuccess() {
		statistics.decreaseSuccess();
		statistics.calcProgress();
	}

	public void deleteFail() {
		statistics.decreaseFail();
		statistics.calcProgress();
	}

	@JsonIgnore
	public int getSuccess() {
		return statistics.getSuccess();
	}

	@JsonIgnore
	public int getFail() {
		return statistics.getFail();
	}

	@JsonIgnore
	public void setRewardToken(int reward) {
		statistics.setRewardToken(reward);
	}

	@JsonIgnore
	public int getRewardToken() {
		return statistics.getRewardToken();
	}

	@JsonIgnore
	public boolean isWinner() {
		return statistics.getRewardToken() > 0;
	}

	@JsonIgnore
	public boolean isLoser() {
		return statistics.getRewardToken() < 0;
	}

	@JsonIgnore
	public boolean isDraw() {
		return statistics.getRewardToken() == 0;
	}
}
