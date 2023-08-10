package com.neibus.model.attendance;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class AttendanceCrmStatisticsDAO {

	protected int attendanceCheckDaysCount;
	protected int attendanceRouletteCount;
	protected int savedValueByAttendanceRoulette;
	protected int monthlyRewardWinCount;
}
