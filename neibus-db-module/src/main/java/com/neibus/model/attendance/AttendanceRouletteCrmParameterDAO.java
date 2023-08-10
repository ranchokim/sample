package com.neibus.model.attendance;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class AttendanceRouletteCrmParameterDAO {

	protected LocalDate startRegDate;
	protected LocalDate endRegDate;
	protected int memberIdx;
	protected int value;
}
