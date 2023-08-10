package com.neibus.model.member;

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
public class MemberCrmStatusUpdateParameter {

	private Integer memberIdx;
	private Status updateTo;
	private Integer mainIdx;
	private String dropType;
	private EnumMemberBlockType blockType;
}
