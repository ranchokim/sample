package com.neibus.model.community;

import static java.lang.String.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.neibus.common.response.ResponseDTO;
import com.neibus.common.util.CommonUtil;
import com.neibus.common.util.FileUtil;
import com.neibus.contentsupport.model.SuperWrite;
import com.neibus.member.model.Member;
import com.neibus.model.common.SuperWriteDAO;

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
public class CommunityComment extends SuperWriteDAO {

	private Long communityCommentId;
	private Long communityBoardId;
	private Integer memberIdx;
	private Integer depth;
	private String content;
	private Integer likeCount;
	private Integer reportCount;
	private String status;
	private Long commentGroup;
	private LocalDateTime regDt;
	private LocalDateTime modDt;

	// FK
	private Member member;
	private CommunityBoard board;

	// Joined Column
	private Boolean isLike;
	private String reportType;

	public static final String DELETE_COMMENT_MESSAGE = "삭제된 댓글이에요.";
	public static final String DELETE_REPLY_MESSAGE = "삭제된 답글이에요.";

	private boolean isMe(int memberIdx) {
		return this.memberIdx == memberIdx;
	}

	public boolean isComment() {
		return depth == 1;
	}

	public boolean isReply() {
		return depth == 2;
	}

	public void fillCommentGroup() {
		commentGroup = isReply() ? communityCommentId : writeId;
	}

	private boolean hideStatus;

	public void markHideUser() {
		hideStatus = true;
	}

	/**
	 * 공통 상세 페이지, 목록 조회에 사용
	 * @param fileUtil
	 * @param memberIdx
	 * @param reportedMemberSet
	 * @return
	 */
	public CommunityCommentResponse toCommentResponse(FileUtil fileUtil, int memberIdx,
			HashSet<Integer> reportedMemberSet) {

		return CommunityCommentResponse.builder()
				.communityCommentId(communityCommentId)
				.memberIdx(this.memberIdx)
				.nickName(member.getNick())
				.profileImageUrl(fileUtil.getImageUrl(member.getCommonFile().makeFullPath()))
				.content(wrapContent())
				.commentGroup(commentGroup)
				.depth(depth)
				.likeCount(likeCount)
				.status(status)
				.me(isMe(memberIdx))
				.hide(hideStatus)
				.like(Optional.ofNullable(isLike).orElse(false))
				.report(isReport()) // 신고 취소 시 DB에서 데이터를 삭제 하기 때문에 null이 아니면 무조건 값이 있음
				.reportedMember(reportedMemberSet.contains(this.memberIdx))
				.regDt(regDt)
				.build();
	}

	public CommunityCommentReplyResponse toReplyResponse(FileUtil fileUtil, int memberIdx,
			HashSet<Integer> reportedMemberSet) {

		return CommunityCommentReplyResponse.builder()
				.communityCommentId(communityCommentId)
				.memberIdx(this.memberIdx)
				.nickName(member.getNick())
				.profileImageUrl(fileUtil.getImageUrl(member.getCommonFile().makeFullPath()))
				.content(wrapContent())
				.depth(depth)
				.likeCount(likeCount)
				.commentGroup(commentGroup)
				.status(status)
				.me(isMe(memberIdx))
				.hide(hideStatus)
				.like(Optional.ofNullable(isLike).orElse(false))
				.report(isReport()) // 신고 취소 시 DB에서 데이터를 삭제 하기 때문에 null이 아니면 무조건 값이 있음
				.reportedMember(reportedMemberSet.contains(this.memberIdx))
				.regDt(regDt)
				.build();
	}

	/**
	 * 마이 페이지의 내 댓글 목록 응답을 만들 때 사용
	 * @return
	 */
	public MyPageCommentsResponse toResponseForMyList() {
		return MyPageCommentsResponse.builder()
				.communityCommentId(communityCommentId)
				.commentContent(wrapContent())
				.communityBoardId(communityBoardId)
				.boardContent(board.getContent())
				.mainCategory(board.getMainCategory())
				.subCategory(board.getSubCategory())
				.likeCount(likeCount)
				.status(status)
				.depth(depth)
				.like(Optional.ofNullable(isLike).orElse(false))
				.report(isReport()) // 신고 취소 시 DB에서 데이터를 삭제 하기 때문에 null이 아니면 무조건 값이 있음
				.regDt(regDt)
				.build();
	}

	private boolean isReport() {
		return reportType != null;
	}

	private String wrapContent() {
		if (isDeleteContent()) {
			return isComment() ? DELETE_COMMENT_MESSAGE : DELETE_REPLY_MESSAGE;
		}

		return content;
	}

	private boolean isDeleteContent() {
		return status.equals("D");
	}

	public String buildReportMessage(int reporter, String reportType) {
		return String.format("커뮤니티: %s\n", EnumMainCategory.findBy(board.getMainCategory()))
				+ String.format("주제: %s\n", EnumSubCategory.findBy(board.getSubCategory()))
				+ String.format("작성자: %s(%d)\n", member.getNick(), memberIdx)
				+ format("신고자: (%d)\n", reporter)
				+ String.format("신고 사유: %s\n", EnumReportType.findBy(reportType))
				+ String.format("게시글: %s\n", board.getContent())
				+ (isComment() ? format("댓글: %s\n", content) : "")
				+ (isReply() ? format("답글: %s\n", content) : "");
	}

	@Getter
	@Setter
	public static class CommunityCommentRequest {
		private Long communityCommentId;
		private String content;
		private Integer depth;

		public CommunityComment toEntity(int memberIdx, Long boardId) {
			return CommunityComment.builder()
					.communityCommentId(communityCommentId)
					.communityBoardId(boardId)
					.memberIdx(memberIdx)
					.content(content)
					.depth(depth)
					.build();
		}
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	@Getter
	@Setter
	public static class CommunityCommentResponse {
		private Long communityCommentId;
		private Integer memberIdx;
		private String nickName;
		private String profileImageUrl;
		private Integer depth;
		private String content;
		private Integer likeCount;
		private String status;
		private Long commentGroup;
		private List<CommunityCommentReplyResponse> replyList;
		private int replySize;

		@JsonProperty("isHide")
		private boolean hide;

		@JsonProperty("isMe")
		private boolean me;

		@JsonProperty("isLike")
		private boolean like;

		@JsonProperty("isReport")
		private boolean report;

		@JsonProperty("isReportedMember")
		private boolean reportedMember;

		private LocalDateTime regDt;

		public String getRegDt() {
			return CommonUtil.makeTimeLine(regDt);
		}
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	@Getter
	@Setter
	public static class CommunityCommentReplyResponse {
		private Long communityCommentId;
		private Integer memberIdx;
		private String nickName;
		private String profileImageUrl;
		private Integer depth;
		private String content;
		private Integer likeCount;
		private String status;
		private Long commentGroup;

		@JsonProperty("isHide")
		private boolean hide;

		@JsonProperty("isMe")
		private boolean me;

		@JsonProperty("isLike")
		private boolean like;

		@JsonProperty("isReport")
		private boolean report;

		@JsonProperty("isReportedMember")
		private boolean reportedMember;

		private LocalDateTime regDt;

		public String getRegDt() {
			return CommonUtil.makeTimeLine(regDt);
		}
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	@Getter
	@Setter
	public static class CommunityCommentListResponseDTO extends ResponseDTO {
		private List<CommunityCommentResponse> comments;
		private boolean hasNextPage;
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	@Getter
	@Setter
	public static class CommunityReplyListResponseDTO extends ResponseDTO {
		private List<CommunityCommentReplyResponse> replies;
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	@Getter
	@Setter
	public static class CommunityCommentDeleteResponseDTO extends ResponseDTO {
		private String deletedContent;
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	@Getter
	@Setter
	public static class MyPageCommentsResponse {
		private Long communityCommentId;
		private Long communityBoardId;
		private String commentContent;
		private String boardContent;
		private String mainCategory;
		private String subCategory;
		private Integer likeCount;
		private String status;
		private Integer depth;

		@JsonProperty("isLike")
		private boolean like;

		@JsonProperty("isReport")
		private boolean report;
		private LocalDateTime regDt;

		public String getRegDt() {
			return CommonUtil.makeTimeLine(regDt);
		}
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	@Getter
	@Setter
	public static class MyPageCommentsListResponseDTO extends ResponseDTO {
		private long totalCount;
		private boolean hasNextPage;
		private List<MyPageCommentsResponse> comments;
	}
}
