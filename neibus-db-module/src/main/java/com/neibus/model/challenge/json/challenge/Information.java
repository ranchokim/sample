package com.neibus.challenge.model.json.challenge;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Information {

	private int totalRecruits;
	private Fee fee;
	private String successConditionImage;
	private String notice;
	private List<String> guideImages;
	private List<String> thumbnails;
	private String popupImage;

	@JsonIgnoreProperties(ignoreUnknown = true)
	@Getter
	@Setter
	public static class Fee {
		private int min;
		private int max;

		public boolean checkValid(int fee) {
			return fee > min && fee < max;
		}
	}
}
