package com.neibus.model.member;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PolicyDao {
	protected static final long serialVersionUID = 1L;

	protected int idx;
	protected String title;
	protected String content;
	protected int memberIdx;
	protected String policyType;
	protected String status;
}
