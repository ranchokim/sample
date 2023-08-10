package com.neibus.model.member;

import java.time.LocalDate;

import com.neibus.member.model.isAgreedTermsOfMyData;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberCrmParameter {

	private LocalDate startRegDate;
	private LocalDate endRegDate;
	private Sex sex;
	private Integer startBirthYear;
	private Integer endBirthYear;
	private String cityCode;
	private String snsTypeCode;
	private HasCi hasCi;
	private HasRecommenderCode hasRecommenderCode;
	private int appVersion;
	private AppVersionCriteria appVersionCriteria;
	private Status status;
	private com.neibus.member.model.isAgreedTermsOfMyData isAgreedTermsOfMyData;
	private OsType osType;
	private long idx;
	private String mobileNo;
	private String nickname;
	private String email;
	private String name;
	private String uniqueCode;
	private String recommenderCode;
}
