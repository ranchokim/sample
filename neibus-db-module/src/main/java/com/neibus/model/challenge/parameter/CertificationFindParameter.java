package com.neibus.challenge.model.parameter;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CertificationFindParameter {

	private Long challengeId;
	private int memberId;
	private LocalDate searchDate;
}
