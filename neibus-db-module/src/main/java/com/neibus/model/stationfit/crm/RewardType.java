package com.neibus.model.stationfit.crm;

import lombok.Getter;

@Getter
public enum RewardType {

    DEFAULT, // 미적립 (일반형 정류장핏은 모두 미적립)
    FIXED, // 고정형
    RANDOM // 차등형
}
