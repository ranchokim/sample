package com.neibus.model.stationfit;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {

  private Integer categoryId;
  private String type;
  private String code;
  private String name;
  private LocalDateTime createDatetime;
  private LocalDateTime updateDatetime;
}
