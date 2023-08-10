package com.neibus.model.community;

public enum EnumReportType {
  AD("CRT01", "광고/홍보 글이에요."),
  ABUSE("CRT02", "욕설/비방 글이에요."),
  PORN("CRT03", "음란물이 포함된 글이에요."),
  DEATH_MATCH("CRT04", "집단간 싸움을 유발하는 글이에요."),
  PRIVACY("CRT05", "개인정보가 노출된 글이에요."),
  DUPLICATE_CONTENT("CRT06", "중복/도배성 글이에요."),
  ;

  private String reportCode;
  private String description;

  EnumReportType(String reportCode, String description) {
    this.reportCode = reportCode;
    this.description = description;
  }

  public static String findBy(String code) {
    for (EnumReportType value : values()) {
      if (value.reportCode.equals(code)) {
        return value.description;
      }
    }
    return null;
  }
}
