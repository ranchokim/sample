package com.neibus.challenge.model.json.statistics;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.neibus.challenge.model.ChallengedBox;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Achievement {

	private int recruited;
	private int success;
	private int fail;
	private int totalGoal;
	private int progress;
	private List<Result> results;
	private List<Winner> winners;

	public void increaseRecruit() {
		recruited++;
	}

	public void accumulateSumSuccess(List<ChallengedBox> boxes) {
		success = boxes.stream().mapToInt(ChallengedBox::getSuccess).sum();
	}

	public void accumulateSumFail(List<ChallengedBox> boxes) {
		fail = boxes.stream().mapToInt(ChallengedBox::getFail).sum();
	}

	public void calcProgress() {
		if (totalGoal == 0) {
			progress = 0;
			return;
		}

		progress = (int)((float)success / (float)totalGoal * 100.0);
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@JsonIgnoreProperties(ignoreUnknown = true)
	@Getter
	@Setter
	public static class Result {
		private String key;
		private int value;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	@Getter
	@Setter
	@NoArgsConstructor
	public static class Winner {
		private String nick;
		private int memberId;

		private Winner(int memberId) {
			this.nick = "";
			this.memberId = memberId;
		}

		public static Winner of(int memberId) {
			return new Winner(memberId);
		}
	}
}
