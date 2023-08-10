package com.neibus.model.challenge.json.certificationcondition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class CheckList {

	protected static final int walking = 10;
	protected static final int imageType = 1;
	protected static final int boardingTime = 100;

	protected String label;
	protected String labelType;
}
