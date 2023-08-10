package com.neibus.challenge.model.json.challenge;

import static org.springframework.util.StringUtils.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Reward {

	private String policyImage;
	private String policyTitle;
	private List<Policy> policy;

	public Policy findSatisfiedRewardPolicy(int success) {
		for (Policy p : policy) {
			if (p.satisfied(success)) {
				return p;
			}
		}
		return Policy.empty();
	}

	public int calcReward(int fee, int success) {
		Policy satisfiedPolicy = findSatisfiedRewardPolicy(success);

		if (satisfiedPolicy.isEmpty()) {
			return 0;
		}

		return satisfiedPolicy.calcReward(fee);
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	@Getter
	@Setter
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Policy {
		private String type;
		private int satisfyValue;
		private String op;
		private String name;
		private int fixed;
		private float rate;

		public static Policy empty() {
			Policy policy = new Policy();
			policy.setName("");
			return policy;
		}

		public boolean satisfied(int success) {
			return switch (op) {
				case "eq" -> success == satisfyValue;
				case "gt" -> success > satisfyValue;
				case "lt" -> success < satisfyValue;
				case "gte" -> success >= satisfyValue;
				case "lte" -> success <= satisfyValue;
				default -> false;
			};
		}

		public int calcReward(int fee) {
			return (int)(fee * rate) + fixed;
		}

		@JsonIgnore
		public boolean isEmpty() {
			return !hasText(name);
		}
	}
}