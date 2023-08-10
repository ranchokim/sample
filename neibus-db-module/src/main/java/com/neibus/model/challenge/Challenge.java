package com.neibus.model.challenge;

import static com.neibus.common.domain.enumable.EnumErrorCode.*;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neibus.challenge.model.Certification;
import com.neibus.challenge.model.CertificationCondition;
import com.neibus.challenge.model.ChallengeStatus;
import com.neibus.challenge.model.ChallengeTemplate;
import com.neibus.challenge.model.ChallengedBox;
import com.neibus.challenge.model.MainCategory;
import com.neibus.model.common.OsType;
import com.neibus.challenge.model.Statistics;
import com.neibus.challenge.model.SubCategory;
import com.neibus.challenge.model.json.challenge.Information;
import com.neibus.challenge.model.json.challenge.Reward;
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
public class Challenge {

	private Long challengeId;
	private Long advertiserId;
	private Long templateId;
	private Integer adId;
	private MainCategory mainCategory;
	private SubCategory subCategory;
	private String title;
	private String subTitle;
	private String subTitleImage;
	private Long round;
	private LocalDateTime startAt;
	private LocalDateTime endAt;
	private Information information;
	private Reward reward;
	private boolean visible;
	private State state;
	private LocalDateTime createdAt;
	private ChallengeStatus challengeStatus;
	private Statistics statistics;
	private CertificationCondition certificationCondition;
	private List<Certification> myCertifications;
	private ChallengedBox challengedBox;
	private OsType osType;
	private ChallengeTemplate template;

	public String getStateValue() {
		if (this.state == null) {
			return null;
		}
		return this.state.name();
	}

	public void fin() {
		state = State.FIN;
	}

	public void recruit() {
		state = State.RECRUIT;
	}

	public void close() {
		state = State.CLOSE;
	}

	public String compressorSubTitle() {
		if (subTitle.length() > 15) {
			return subTitle.substring(0, 15) + "...";
		}

		return subTitle;
	}

	@JsonIgnore
	public boolean isRecruitPeriod() {
		return LocalDateTime.now().isBefore(startAt);
	}

	@JsonIgnore
	public boolean isChallenging() {
		LocalDateTime now = LocalDateTime.now();
		return now.isAfter(startAt) || now.isBefore(endAt);
	}

	public void checkJoinValidate(int fee) {
		if (!isRecruitPeriod()) {
			throw new ClientException.Forbidden(CHALLENGE_NOT_RECRUITING_PERIOD);
		}
		checkFeeValid(fee);
	}

	private boolean checkFeeValid(int fee) {
		return information.getFee().checkValid(fee);
	}

	public String getSatisfiedPolicyName(int value) {
		Reward.Policy policy = reward.findSatisfiedRewardPolicy(value);
		return policy.getName();
	}

	public int calcReward(int fee, int success) {
		return reward.calcReward(fee, success);
	}

	public enum State {RECRUIT, FIN, PROGRESS, CLOSING, CLOSE}
}
