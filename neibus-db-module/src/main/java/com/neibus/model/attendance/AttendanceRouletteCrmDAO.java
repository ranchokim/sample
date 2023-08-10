package com.neibus.model.attendance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendanceRouletteCrmDAO {

	protected Integer rewardWinnerId;
	protected Integer memberIdx;
	protected Integer value;
	protected LocalDateTime regDateTime;
	protected Integer count;
	protected LocalDate regDate;
	protected LocalTime regTime;
}
