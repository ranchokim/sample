package com.neibus.challenge.model.parameter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CertCrmDeleteParam {
	private Long challengeId;
	private Long certificationId;
	private int memberId;
}
