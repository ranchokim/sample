package com.neibus.model.stationfit;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@Getter
public enum StationFitType {
	DEFAULT, QUIZ, REVIEW, WAITING,
	;

	@JsonIgnore
	public static List<StationFitType> getMissionTypes() {
		return Arrays.stream(values()).filter(type -> type != DEFAULT).toList();
	}
}
