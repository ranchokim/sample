package com.neibus.model.stationfit;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class FitRewardLog {

	private Long fitRewardLogId;
	private Long stationFitId;
	private Integer memberIdx;
	private Integer rewardValue;
	private LocalDateTime createdAt;

	public static FitRewardLog empty() {
		return FitRewardLog.builder()
				.rewardValue(0)
				.fitRewardLogId(0L)
				.build();
	}
}
