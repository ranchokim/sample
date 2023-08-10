package com.neibus.model.challenge.json.certification;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Information {
	protected String label;
	protected String certificationImage;
	protected String imageMetaData;
	protected List<Data> data;
	protected ImageType imageType;

	public enum ImageType {
		TAKEN, // 촬영
		ATTACH // 첨부
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	@Getter
	@Setter
	@NoArgsConstructor
	public static class Data {
		private String key;
		private int value;

		public Data(String key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}

