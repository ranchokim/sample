package com.neibus.model.stationfit.crm;

import java.time.LocalDateTime;

import com.neibus.stationfit.model.StationFit;
import com.neibus.stationfit.model.StationFitStatus;
import com.neibus.stationfit.model.StationFitType;
import com.neibus.stationfit.model.StoreType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StationFitShowListParam {

    private String area;
    private StoreType storeType;
    private StationFitType type;
    private LocalDateTime postStartDatetime;
    private LocalDateTime postEndDatetime;
    private StationFit.Progress progress;
    private RewardType rewardType;
    private String title;
    private Long stationFitId;
    private String stationId;
    private String stationNo;
    private StationFitStatus status;
    private Integer itemId;

    // paging
    private Integer startItemIdx;
    private Integer pageSize;
}
