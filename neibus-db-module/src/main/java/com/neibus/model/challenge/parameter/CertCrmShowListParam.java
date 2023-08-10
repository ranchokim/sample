package com.neibus.challenge.model.parameter;

import java.time.LocalDate;

import com.neibus.challenge.model.json.certification.Information;
import com.neibus.challenge.model.Certification.State;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CertCrmShowListParam {

	private Long challengeId;
	private LocalDate startCertDate;
	private LocalDate endCertDate;
	private Integer memberIdx;
	private Integer certificationId;
	private String nickname;
	private State state;
	private Boolean visible;
	private Information.ImageType imageType;
}
