package com.neibus.challenge.model.json.statistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Reward {

	private int fail; // 음수값
	private int reward;
	private int fee;

	public int calcTotalReward() {
		return reward + fee + fail;
	}
}
