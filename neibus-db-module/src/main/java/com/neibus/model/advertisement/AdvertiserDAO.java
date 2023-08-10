package com.neibus.model.advertisement;

import java.time.LocalDateTime;

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
public class AdvertiserDAO {

	protected Integer advertiserId;
	protected String advertiserName;
	protected String storeName;
	protected String address;
	protected String businessNumber;
	protected String contact;
	protected String email;
	protected String memo;
	protected LocalDateTime createdAt;
	protected LocalDateTime updatedAt;
	protected Integer totalCount;
}
