package com.neibus.model.member;

import java.io.Serializable;

import com.neibus.common.util.DateUtil;
import com.neibus.member.util.VersionUtil;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Version implements Serializable {

  private static final long serialVersionUID = 1L;

  private int idx;
  private String title;
  private String content;
  private String versionNm;
  private String os;
  private String noticeType;
  private String serverType;
  private String aosV;
  private String iosV;
  private String regDt;

  public String getRegDt() {
    return DateUtil.changeDateFormat(regDt, DateUtil.DEFAULT_FORMAT);
  }

  public boolean isEqualOs(String os) {
    return this.os.equals(os);
  }

  public int calcVersion() {
    return VersionUtil.getInstance().calcVersion(versionNm);
  }

  public boolean isGreaterThan(String appVersion) {
    int appVersionNum = VersionUtil.getInstance().calcVersion(appVersion);
    int requireVersionNum = calcVersion();

    return requireVersionNum > appVersionNum;
  }
}
