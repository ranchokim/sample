package com.neibus.challenge.model;

import java.time.LocalDateTime;
import java.util.List;

import com.neibus.challenge.model.json.statistics.Achievement;
import com.neibus.challenge.model.json.statistics.Reward;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Statistics {

	private Long statisticsId;
	private Long challengeId;
	private LocalDateTime startAt;
	private LocalDateTime endAt;
	private Integer recruited;
	private Achievement achievement;
	private Reward reward;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public void overwriteRecruited(Integer recruited) {
		this.recruited = recruited;
		achievement.setRecruited(recruited);
	}

	public void overwriteRewardFee(Integer rewardFee) {
		int fee = reward.getFee() + rewardFee;
		reward.setFee(fee);
	}

	public void updateTotalGoal(int totalGoal) {
		achievement.setTotalGoal(totalGoal);
	}

	public void accumulateSum(List<ChallengedBox> boxes) {
		achievement.accumulateSumSuccess(boxes);
		achievement.accumulateSumFail(boxes);
	}

	public void updateProgress() {
		achievement.calcProgress();
	}

	public void renewWinner(List<ChallengedBox> boxes) {
		List<Achievement.Winner> winners = boxes.stream()
				.filter(ChallengedBox::isSuccess)
				.map(ChallengedBox::getMemberId)
				.map(Achievement.Winner::of)
				.toList();

		achievement.setWinners(winners);
	}

	public void setAchievementResult(List<Achievement.Result> results) {
		achievement.setResults(results);
	}
}
