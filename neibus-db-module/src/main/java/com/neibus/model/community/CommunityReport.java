package com.neibus.model.community;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommunityReport {

	private Long communityReportId;
	private Long writeId;
	private Integer memberIdx;
	private String reportTarget;
	private String reportType;
	private LocalDateTime regDt;

	public boolean reportMember() {
		return reportTarget != null && reportTarget.equals("MEMBER");
	}

	public boolean reportContent() {
		return reportTarget != null && reportTarget.equals("CONTENT");
	}
}
