package com.neibus.model.community;

public enum EnumMainCategory {
  BUS("CMT01", "버스"),
  SUBWAY("CMT02", "지하철"),
  BICYCLE("CMT03", "자전거"),
  KICK_BOARD("CMT04", "킥보드"),
  ETC("CMT09", "기타"),
  TAXI("CMT05", "택시"),
  ;

  private String categoryCode;
  private String description;

  EnumMainCategory(String categoryCode, String description) {
    this.categoryCode = categoryCode;
    this.description = description;
  }

  public static String findBy(String code) {
    for (EnumMainCategory value : values()) {
      if (value.categoryCode.equals(code)) {
        return value.description;
      }
    }
    return null;
  }

}
