package com.neibus.challenge.model.parameter;

import java.time.LocalDate;

import com.neibus.challenge.model.MainCategory;
import com.neibus.model.common.OsType;
import com.neibus.challenge.model.SubCategory;
import com.neibus.challenge.model.crm.State;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * CRM API 조회용
 */
@Getter
@Setter
@Builder
public class ChallengeCrmShowListParam {

	private MainCategory mainCategory;
	private SubCategory subCategory;
	private Long challengeId;
	private Long advertiserId;
	private Integer itemId;
	private String title;
	private String subTitle;
	private State state;
	private Boolean visible;
	private OsType osType;
	private LocalDate startDate;
	private LocalDate endDate;
}
