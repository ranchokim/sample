package com.neibus.challenge.model.parameter;

import com.neibus.challenge.model.MainCategory;
import com.neibus.model.common.OsType;
import com.neibus.challenge.model.SubCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TemplateCrmShowListParam {
	private MainCategory mainCategory;
	private SubCategory subCategory;
	private String status;
	private OsType osType;
	private String title;
	private String subTitle;
	private Integer templateId;
	private Integer itemId;
	private Integer totalRound;
}
