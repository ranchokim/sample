package com.neibus.challenge.model;

import java.time.LocalDateTime;
import java.util.List;

import com.neibus.challenge.model.json.certificationcondition.CheckList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertificationCondition {

	private Long certificationConditionId;
	private Long challengeId;
	private Integer daily;
	private Integer weekly;
	private Integer goal;
	private Integer cycleMin;
	private List<CheckList> checkList;
	private LocalDateTime createdAt;

	public int calcTotalGoal(int recruited) {
		return goal * recruited;
	}
}
