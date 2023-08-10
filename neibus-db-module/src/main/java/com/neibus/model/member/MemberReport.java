package com.neibus.model.member;

import static java.lang.String.*;

import java.time.LocalDateTime;

import com.neibus.common.domain.enumable.EnumErrorCode;
import com.neibus.common.exception.ClientException;
import com.neibus.member.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MemberReport {

	private Integer reportMemberId;
	private Integer memberIdx;
	private Integer reportedMemberIdx;
	private String reportType;
	private LocalDateTime regDt;
	private LocalDateTime modDt;

	public String buildReportMessage(MemberMapper memberMapper) {
		Member reportedMember = memberMapper.selectByIdx(reportedMemberIdx);

		if (reportedMember == null) {
			throw new ClientException.NotFound(EnumErrorCode.ERROR_NOT_FOUND_USER);
		}

		Member reporter = memberMapper.selectByIdx(memberIdx);

		return String.format("신고대상: %s(%d)\n", reportedMember.getNick(), reportedMember.getIdx())
				+ format("신고자: (%d)\n", reporter.getIdx())
				+ String.format("신고사유: %s\n", EnumMemberReportType.findBy(reportType));
	}
}
