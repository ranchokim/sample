package com.neibus.model.advertisement;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementDAO {

	protected Integer itemId;
	protected Integer advertiserId;
	protected String itemName;
	protected LocalDateTime createdAt;
	protected LocalDateTime updatedAt;

	protected AdvertiserDAO advertiser;
	protected Integer fitCount;
	protected Integer challengeCount;
	protected Integer popupCount;

}
