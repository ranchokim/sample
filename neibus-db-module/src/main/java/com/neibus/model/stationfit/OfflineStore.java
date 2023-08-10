package com.neibus.model.stationfit;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfflineStore {
  private Integer offlineStoreId;
  private Long stationFitId;
  private String name;
  private String introduce;
  private String operation;
  private String contact;
  private String address;
  private String addressDescription;
  private Double gpsX;
  private Double gpsY;
  private String storeUrl;
  private LocalDateTime createDatetime;
  private LocalDateTime updateDatetime;

	public void patch(OfflineStore offlineStore) {
		this.name = offlineStore.getName() == null ? this.name : offlineStore.getName();
		this.introduce = offlineStore.getIntroduce() == null ? this.introduce : offlineStore.getIntroduce();
		this.operation = offlineStore.getOperation() == null ? this.operation : offlineStore.getOperation();
		this.contact = offlineStore.getContact() == null ? this.contact : offlineStore.getContact();
		this.address = offlineStore.getAddress() == null ? this.address : offlineStore.getAddress();
		this.addressDescription = offlineStore.getAddressDescription() == null ? this.addressDescription : offlineStore.getAddressDescription();
		this.gpsX = offlineStore.getGpsX() == null ? this.gpsX : offlineStore.getGpsX();
		this.gpsY = offlineStore.getGpsY() == null ? this.gpsY : offlineStore.getGpsY();
		this.storeUrl = offlineStore.getStoreUrl() == null ? this.storeUrl : offlineStore.getStoreUrl();
	}
}
