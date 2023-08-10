package com.neibus.model.stationfit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MissionStatus {
	private Long missionStatusId;
	private Long stationFitId;
	private Integer participationGoals;
	private Integer participationLimitCount;
	private Integer participatedCount;
	private ParticipationType participationType;

	public void increaseParticipatedCount() {
		this.participatedCount++;
	}

	public boolean isGoals() {
		return participationGoals <= participatedCount; // 모두 참여 했을 경우 같아야 함. count가 goals를 게 크넘어서는 경우를 방지
	}
}
