package com.neibus.challenge.model.parameter;

import com.neibus.challenge.model.Certification;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * APP API 조회용
 */
@Getter
@Setter
@Builder
public class CertificationShowListParameter {
	private Long challengeId;
	private Long certificationId;
	private Integer memberIdx;
	private Boolean visible;
	private Certification.State state;
	private int pageSize;
}
