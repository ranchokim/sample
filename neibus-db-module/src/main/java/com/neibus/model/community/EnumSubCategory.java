package com.neibus.model.community;

public enum EnumSubCategory {
  GENERAL("CST01", "일상"),
  QUESTION("CST02", "질문"),
  INFORMATION("CST03", "소식/정보"),
  LOST_CENTER("CST04", "분실센터"),
  ETC("CST05", "기타"),
  HOME("CST00", "홈"),
  ;

  private String categoryCode;
  private String description;

  EnumSubCategory(String categoryCode, String description) {
    this.categoryCode = categoryCode;
    this.description = description;
  }

  public static String findBy(String code) {
    for (EnumSubCategory value : values()) {
      if (value.categoryCode.equals(code)) {
        return value.description;
      }
    }
    return null;
  }
}
