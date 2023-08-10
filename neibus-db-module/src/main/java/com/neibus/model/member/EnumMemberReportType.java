package com.neibus.model.member;

public enum EnumMemberReportType {
  MEMBER_AD("MRT01", "광고/홍보 글 작성자에요."),
  MEMBER_ABUSE("MRT02", "욕설/비방 글 작성자에요."),
  MEMBER_DEATH_MATCH("MRT03", "집단간 싸움을 유발한 사용자에요."),
  MEMBER_PRIVACY("MRT04", "개인정보를 노출한 사용자에요."),
  MEMBER_DUPLICATION("MRT05", "중복/도배성 글 작성자에요."),
  MEMBER_PROFILE_NICKNAME("MRT06", "불건전한 프로필/닉네임 사용자에요."),
  ;

  private String reportCode;
  private String description;

  EnumMemberReportType(String reportCode, String description) {
    this.reportCode = reportCode;
    this.description = description;
  }

  public static String findBy(String code) {
    for (EnumMemberReportType value : values()) {
      if (value.reportCode.equals(code)) {
        return value.description;
      }
    }
    return null;
  }
}
