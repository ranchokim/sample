package com.neibus.model.stationfit;

import java.time.LocalDateTime;

import com.neibus.model.common.SuperWriteDAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StationFitComment extends SuperWriteDAO {

  private Long stationFitCommentId;
  private Long stationFitId;
  private Long fitRewardLogId;
  private Integer memberIdx;
  private String content;
  private Integer likeCount;
  private LocalDateTime createDatetime;
  private LocalDateTime updateDatetime;

  private Member member;
  private FitRewardLog fitRewardLog;

  // 실제 컬럼이 아닌 필드
  private Boolean isLikeClicked;

  public boolean isDecreasableLike() {
    return this.likeCount > 0;
  }

  public static StationFitComment createWaitingMissionComment(Long stationFitId, int memberIdx) {
	  return StationFitComment.builder()
			  .stationFitId(stationFitId)
			  .memberIdx(memberIdx)
			  .content("참여완료")
			  .build();
  }
}
