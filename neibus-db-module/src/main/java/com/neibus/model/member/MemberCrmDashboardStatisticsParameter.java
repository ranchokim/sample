package com.neibus.model.member;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberCrmDashboardStatisticsParameter {
	private List<Status> status;
	private HasRecommenderCode hasRecommenderCode;
	private LocalDate startRegDate;
	private LocalDate endRegDate;
	private LocalDate startDropDate;
	private LocalDate endDropDate;
	private LocalDate endMergedDate;
}
