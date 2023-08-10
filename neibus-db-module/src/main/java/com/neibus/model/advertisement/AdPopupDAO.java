package com.neibus.model.advertisement;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AdPopupDAO {
	protected Integer id;
	protected Long adId;
	protected Integer itemId;
	protected CategoryType category;
	protected PositionType position;
	protected StyleType style;
	protected String title;
	protected LocalDateTime startAt;
	protected LocalDateTime endAt;
	protected LocalDate startDate;
	protected LocalDate endDate;
	protected LocalTime startTime;
	protected LocalTime endTime;
	protected String status;
	protected DirectionType directionType;
	protected String domain;
	protected String directionPage;
	protected String directionContentId;
	protected String directionUrl;
	protected String popupImage;
	protected Integer viewCount;
	protected LocalDateTime createdAt;
	protected LocalDateTime updatedAt;

}
