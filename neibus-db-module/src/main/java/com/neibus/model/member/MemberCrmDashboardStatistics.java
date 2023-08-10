package com.neibus.model.member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberCrmDashboardStatistics {
	private int totalMembers;
	private int totalWithdrawalMembers;
	private int totalActiveMembers;
	private int totalMergedMembers;
	private int newMembers;
	private int invitedMembers;
	private int withdrawalMembers;
	private int holdingMembers;
	private int blockedMembers;
}
