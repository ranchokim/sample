package com.neibus.challenge.model;

import java.time.LocalDateTime;
import java.util.List;

import com.neibus.challenge.model.json.certificationcondition.CheckList;
import com.neibus.challenge.model.json.challenge.Information;
import com.neibus.challenge.model.json.challenge.Reward;
import com.neibus.challenge.model.json.challengetemplate.Condition;
import com.neibus.model.common.OsType;

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
public class ChallengeTemplate {
	private Integer templateId;
	private Integer advertiserId;
	private Integer itemId;
	private String category;
	private MainCategory mainCategory;
	private SubCategory subCategory;
	private String title;
	private String subTitle;
	private String subTitleImage;
	private Integer round;
	private Integer totalRound;
	private Information information;
	private List<CheckList> checkList;
	private Reward reward;
	private String status;
	private LocalDateTime startDate;
	private Integer duration;
	private Integer schedule;
	private OsType osType;
	private Condition condition;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
