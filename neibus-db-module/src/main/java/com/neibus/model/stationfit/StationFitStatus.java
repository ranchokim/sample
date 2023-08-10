package com.neibus.model.stationfit;

public enum StationFitStatus {
  Y("시작"), N("종료"), D("삭제");

  private String status;

  StationFitStatus(String status) {
    this.status = status;
  }
}
