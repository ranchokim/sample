package com.neibus.model.stationfit;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Advertiser {
  private Integer advertiserId;
  private String advertiserName;
  private String storeName;
  private String address;
  private String contact;
  private String email;
  private LocalDateTime createDatetime;
  private LocalDateTime updateDatetime;
  private Integer stationFitCount;

  public Advertiser(Integer advertiserId) {
    this.advertiserId = advertiserId;
  }
}
