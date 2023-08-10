package com.neibus.model.member;

import lombok.Getter;

@Getter
public enum EnumSNS {
  KAKAO("KAKAO", "ST001"),
  FACEBOOK("FACEBOOK", "ST002"),
  NAVER("NAVER", "ST003"),
  GOOGLE("GOOGLE", "ST004"),
  APPLE("APPLE", "ST005"),
  ETC("ETC", "ST999");

  private String name;
  private String code;

  EnumSNS(String name, String code) {
    this.name = name;
    this.code = code;
  }

  public static EnumSNS fromString(String text) {
    for (EnumSNS value : EnumSNS.values()) {
      if (value.code.equalsIgnoreCase(text)) {
        return value;
      }
    }
    return ETC;
  }
}