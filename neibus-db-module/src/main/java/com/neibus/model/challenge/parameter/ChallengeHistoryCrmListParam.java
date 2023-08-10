package com.neibus.challenge.model.parameter;

import java.time.LocalDate;

import com.neibus.challenge.model.MainCategory;
import com.neibus.challenge.model.SubCategory;
import com.neibus.challenge.model.crm.State;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeHistoryCrmListParam {

	private Integer memberIdx;
	private LocalDate startDate;
	private LocalDate endDate;
	private MainCategory mainCategory;
	private SubCategory subCategory;
	private State state;
}
