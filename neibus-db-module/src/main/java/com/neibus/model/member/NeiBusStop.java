package com.neibus.model.member;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.neibus.common.domain.Paging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NeiBusStop implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idx;
    private String stationNm;
    private double gpsX;
    private double gpsY;
    private String mobileNo;
    private String area;
	private String stationNmParse;
    private String stationType;
    private String direction;
	private String serviceYn;
	private Integer apiId;
    private String keyword;
    private String isFavorite;
    private int radius;
    private String stationId;
    private Paging paging;
    private String cityCode;
	private LocalDateTime regDt;
	private LocalDateTime modDt;
}
