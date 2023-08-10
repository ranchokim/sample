package com.neibus.model.banner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.neibus.model.common.OsType;
import com.neibus.model.contentsupport.S3ImageDAO;

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
public class BannerDao {

	protected Integer bannerId;
	protected PositionType positionType;
	protected String title;
	protected LocalDateTime postStartDatetime;
	protected LocalDateTime postEndDatetime;
	protected LocalDate postStartDate;
	protected LocalDate postEndDate;
	protected LocalTime postStartTime;
	protected LocalTime postEndTime;
	protected BannerStatus status;
	protected DirectionType directionType;
	protected DomainType domain;
	protected String directionPage;
	protected String directionContentId;
	protected String directionUrl;
	protected Long bannerImageId;
	protected OsType osType;
	protected LocalDateTime createDatetime;
	protected LocalDateTime updateDatetime;

	protected S3ImageDAO bannerImage;

	protected String query;
}