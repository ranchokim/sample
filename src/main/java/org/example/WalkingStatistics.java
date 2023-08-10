package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WalkingStatistics {
    private Long walkingStatisticsId;
    private Integer memberIdx;
    private LocalDate deviceDt;
    private Integer stepsCount;
    private Double distance;
    private Double co2Reduction;
    private Double pineTreeCount;
    private LocalDateTime createdAt;

    public Long getWalkingStatisticsId() {
        return walkingStatisticsId;
    }

    public void setWalkingStatisticsId(Long walkingStatisticsId) {
        this.walkingStatisticsId = walkingStatisticsId;
    }

    public Integer getMemberIdx() {
        return memberIdx;
    }

    public void setMemberIdx(Integer memberIdx) {
        this.memberIdx = memberIdx;
    }

    public LocalDate getDeviceDt() {
        return deviceDt;
    }

    public void setDeviceDt(LocalDate deviceDt) {
        this.deviceDt = deviceDt;
    }

    public Integer getStepsCount() {
        return stepsCount;
    }

    public void setStepsCount(Integer stepsCount) {
        this.stepsCount = stepsCount;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getCo2Reduction() {
        return co2Reduction;
    }

    public void setCo2Reduction(Double co2Reduction) {
        this.co2Reduction = co2Reduction;
    }

    public Double getPineTreeCount() {
        return pineTreeCount;
    }

    public void setPineTreeCount(Double pineTreeCount) {
        this.pineTreeCount = pineTreeCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "WalkingStatistics{" +
                "walkingStatisticsId=" + walkingStatisticsId +
                ", memberIdx=" + memberIdx +
                ", deviceDt=" + deviceDt +
                ", stepsCount=" + stepsCount +
                ", distance=" + distance +
                ", co2Reduction=" + co2Reduction +
                ", pineTreeCount=" + pineTreeCount +
                ", createdAt=" + createdAt +
                '}';
    }

}
