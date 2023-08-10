package com.neibus.challenge.model.parameter;

import com.neibus.challenge.model.Certification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class RejectCertificationParam {

	private Long certificationId;
	private Long challengeId;
	private Integer memberId;
	private Certification.State state;
	private Boolean visible;
	private String rejectMsg;
	private String certificatedAt;
}
