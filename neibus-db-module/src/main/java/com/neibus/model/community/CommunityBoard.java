package com.neibus.model.community;

import static java.lang.String.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.neibus.common.response.ResponseDTO;
import com.neibus.common.util.CommonUtil;
import com.neibus.common.util.FileUtil;
import com.neibus.contentsupport.model.S3Image;
import com.neibus.contentsupport.model.SuperWrite;
import com.neibus.contentsupport.util.S3ImageUtil;
import com.neibus.member.model.Member;
import com.neibus.model.common.SuperWriteDAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CommunityBoard extends SuperWriteDAO {

  private Long communityBoardId;
  private Integer commentCount;
  private Integer memberIdx;
  private String content;
  private Integer likeCount;
  private Integer viewCount;
  private Integer reportCount;
  private String mainCategory;
  private String subCategory;
  private Long imageId;
  private String status;
  private LocalDateTime modDt;
  private LocalDateTime regDt;

  // FK
  private Member member;
  private List<S3Image> s3Images;

  // Transient
  private Boolean isLike;
  private String reportType;

  private boolean isMe(int memberIdx) {
    return this.memberIdx == memberIdx;
  }

  /**
   * 공통 상세 페이지, 목록 조회에 사용
   * @param fileUtil
   * @param memberIdx
   * @param reportedMemberSet
   * @return
   */
  public CommunityBoardResponse toResponse(FileUtil fileUtil, int memberIdx, HashSet<Integer> reportedMemberSet) {
    return CommunityBoardResponse.builder()
        .commentCount(commentCount)
        .communityBoardId(communityBoardId)
		.memberIdx(this.memberIdx)
        .nickName(member.getNick())
        .profileImageUrl(fileUtil.getImageUrl(member.getCommonFile().makeFullPath()))
        .content(content)
        .likeCount(likeCount)
        .images(loadAttachImagesURI())
        .mainCategory(mainCategory)
        .subCategory(subCategory)
        .me(isMe(memberIdx))
        .like(Optional.ofNullable(isLike).orElse(false))
        .report(isReport())
		.reportedMember(reportedMemberSet.contains(this.memberIdx))
        .modDt(modDt)
        .regDt(regDt)
        .build();
  }

  /**
   * 마이 페이지의 내 게시글 목록 응답을 만들 때 사용
   * @return
   */
  public CommunityBoardResponse toResponseForMyList() {
    return CommunityBoardResponse.builder()
        .commentCount(commentCount)
        .communityBoardId(communityBoardId)
        .content(content)
        .likeCount(likeCount)
        .images(loadAttachImagesURI())
        .mainCategory(mainCategory)
        .subCategory(subCategory)
        .like(Optional.ofNullable(isLike).orElse(false))
        .report(isReport())
        .modDt(modDt)
        .regDt(regDt)
        .build();
  }

	/**
	 * 신고 취소 시 DB에서 데이터를 삭제 하기 때문에 무조건 null or value
	 * @return
	 */
	private boolean isReport() {
		return reportType != null;
	}

  public List<String> loadAttachImagesURI() {
    return s3Images.stream()
        .map(S3ImageUtil::requestPublicURI)
        .collect(Collectors.toList());
  }

  public boolean hasImage() {
    if (s3Images == null) {
      return false;
    }

    return !s3Images.isEmpty();
  }

  public boolean isImageEmpty() {
    if (s3Images == null) {
      return true;
    }

    return s3Images.isEmpty();
  }

  public String buildReportMessage(int reporter, String reportType) {
    return String.format("커뮤니티: %s\n", EnumMainCategory.findBy(mainCategory))
        + String.format("주제: %s\n", EnumSubCategory.findBy(subCategory))
        + String.format("작성자: %s(%d)\n", member.getNick(), memberIdx)
        + format("신고자: (%d)\n", reporter)
        + String.format("신고사유: %s\n", EnumReportType.findBy(reportType))
        + format("게시글: %s\n", content);
  }

  public boolean isDelete() {
    return !status.equals("Y");
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  @Getter
  @Setter
  public static class PostBoardResponseDTO extends ResponseDTO {
    private Long communityBoardId;
  }

  @Getter
  @Setter
  public static class CommunityBoardRequest {
    private String content;
    private String mainCategory;
    private String subCategory;

    public CommunityBoard toEntity(Integer memberIdx) {
      return CommunityBoard.builder()
          .content(content)
          .mainCategory(mainCategory)
          .subCategory(subCategory)
          .memberIdx(memberIdx)
          .build();
    }

    public CommunityBoard toEntity(Long boardId) {
      return CommunityBoard.builder()
          .communityBoardId(boardId)
          .content(content)
          .mainCategory(mainCategory)
          .subCategory(subCategory)
          .build();
    }
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  @Getter
  @ToString
  public static class CommunityBoardResponse {
    private Integer commentCount;
    private Long communityBoardId;
	private Integer memberIdx;
    private String nickName;
    private String profileImageUrl;
    private String content;
    private Integer likeCount;
    private List<String> images;

    @JsonProperty("isLike")
    private boolean like;
    private String mainCategory;
    private String subCategory;

    @JsonProperty("isMe")
    private boolean me;

    @JsonProperty("isReport")
    private boolean report;

	@JsonProperty("isReportedMember")
	private boolean reportedMember;

    private LocalDateTime modDt;
    private LocalDateTime regDt;


    public String getModDt() {
      return CommonUtil.makeTimeLine(modDt);
    }

    public String getRegDt() {
      return CommonUtil.makeTimeLine(regDt);
    }
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  @Getter
  @ToString
  public static class CommunityBoardListResponseDTO extends ResponseDTO {
    private List<CommunityBoardResponse> boards;
    private boolean hasNextPage;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  @Getter
  @ToString
  public static class MyPageBoardListResponseDTO extends ResponseDTO {
    private long totalCount;
    private boolean hasNextPage;
    private List<CommunityBoardResponse> boards;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  @Getter
  @ToString
  public static class CommunityBoardDetailResponseDTO extends ResponseDTO {
    private CommunityBoardResponse board;
  }
}
