package com.neibus.model.challenge.crm;

import java.time.LocalDateTime;

import com.neibus.challenge.model.json.challengedbox.MyStatistics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChallengedBoxCrm {

	protected Long challengedBoxId;
	protected Long challengeId;
	protected Integer memberId;
	protected String nickname;
	protected Integer fee;
	protected String notification;
	protected MyStatistics statistics;
	protected LocalDateTime createdAt;
}
