package com.neibus.challenge.model.json.challengedbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MyStatistics {

	private int goal;
	private int success;
	private int fail;
	private int progress;
	private int rewardToken;

	public static MyStatistics ofGoal(int goal) {
		MyStatistics myStatistics = new MyStatistics();
		myStatistics.goal = goal;

		return myStatistics;
	}

	public void increaseSuccess() {
		success++;
	}

	public void decreaseSuccess() {
		success--;
	}

	public void increaseFail() {
		fail++;
	}

	public void decreaseFail() {
		fail--;
	}

	public boolean isSuccess() {
		return success == goal;
	}

	public void calcProgress() {
		progress = (int)(success / (float)goal * 100);
	}
}
