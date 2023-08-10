package com.neibus.model.member;

import java.io.File;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommonFileV2 {

  private Integer idx;
  private String fileGroupType;
  private String filePath;
  private String fileOrgName;
  private String fileSysName;
  private String regDt;

  public String makeAwsFilePath() {
    return File.separator + filePath + File.separator + fileSysName;
  }
}
