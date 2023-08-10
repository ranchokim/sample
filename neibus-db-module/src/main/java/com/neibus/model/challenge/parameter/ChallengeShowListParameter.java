package com.neibus.challenge.model.parameter;

import java.time.LocalDate;
import java.util.List;

import com.neibus.challenge.model.Challenge;
import com.neibus.challenge.model.ChallengedBox;
import com.neibus.model.common.OsType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * APP API 조회용
 */
@Getter
@Setter
@Builder
public class ChallengeShowListParameter {
	private Long challengeId;
	private int pageSize;
	private List<Challenge.State> stateList;
	private Integer memberId;
	private String customCursor;
	private ChallengedBox.Status boxStatus;
	private List<Challenge.State> states;
	private OsType osType;
	private LocalDate endAt;
}
