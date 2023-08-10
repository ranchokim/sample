package com.neibus.model.stationfit;

import static com.neibus.stationfit.model.StationFitStatus.*;
import static com.neibus.stationfit.model.StationFitType.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.util.StringUtils;

import com.neibus.contentsupport.model.S3Image;
import com.neibus.member.model.NeiBusStop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(of = {"stationFitId"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StationFit {

	private Long stationFitId;
	private Long adId;
	private Integer itemId;
	private String stationId;
	private String area;
	private String stationNo;
	private String stationName;
	private StationFitType type;
	private StoreType storeType;
	private String title;
	private PopupAdStatus popupAdStatus;
	private Long popupAdImageId;
	private Long bigAdImageId;
	private Long mediumAdImageId;
	private Long smallAdImageId;
	private LocalDateTime postStartDatetime;
	private LocalDateTime postEndDatetime;
	private LocalDate postStartDate;
	private LocalDate postEndDate;
	private LocalTime postStartTime;
	private LocalTime postEndTime;
	private Progress progress;
	private StationFitStatus status;
	private Integer rewardAmount;
	private Integer rewardBalance;
	private Integer rewardValue;
	private Long rewardManagerId;
	private String popupSubtitle;
	private String quizAnswer;
	private String quizHintUrl;
	private Integer participationGoals;
	private Integer participationLimitCount;
	private ParticipationType participationType;
	private String buttonName;
	private Double version;
	private Integer waitingSeconds;
	private String etcInfo;
	private OsType osType;
	private LocalDateTime createDatetime;
	private LocalDateTime updateDatetime;

	private Advertiser advertiser;
	private OfflineStore offlineStore;
	private S3Image popupAdImage;
	private S3Image bigAdImage;
	private S3Image mediumAdImage;
	private S3Image smallAdImage;
	private NeiBusStop neiBusStop;
	private List<StationFitComment> comments;
	private MissionStatus missionStatus;

	public StationFit(Long stationFitId) {
		this.stationFitId = stationFitId;
	}

	public boolean isDefaultAd() {
		if (type == null) {
			return false;
		}

		return type == DEFAULT;
	}

	public boolean isMissionType() {
		if (type == null) {
			return false;
		}

		return type == QUIZ || type == WAITING;
	}

	public boolean isReviewAd() {
		if (type == null) {
			return false;
		}

		return type == REVIEW;
	}

	public void patch(StationFit stationFit) {
		this.stationId = stationFit.getStationId() == null ? this.stationId : stationFit.getStationId();
		this.adId = stationFit.getAdId() == null ? this.adId : stationFit.getAdId();
		this.itemId = stationFit.getItemId() == null ? this.itemId : stationFit.getItemId();
		this.area = stationFit.getArea() == null ? this.area : stationFit.getArea();
		this.stationNo = stationFit.getStationNo() == null ? this.stationNo : stationFit.getStationNo();
		this.stationName = stationFit.getStationName() == null ? this.stationName : stationFit.getStationName();
		this.type = stationFit.getType() == null ? this.type : stationFit.getType();
		this.storeType = stationFit.getStoreType() == null ? this.storeType : stationFit.getStoreType();
		this.title = stationFit.getTitle() == null ? this.title : stationFit.getTitle();
		this.popupAdStatus = stationFit.getPopupAdStatus() == null ? this.popupAdStatus : stationFit.getPopupAdStatus();
		this.postStartDatetime = stationFit.getPostStartDatetime() == null ? this.postStartDatetime : stationFit.getPostStartDatetime();
		this.status = stationFit.getStatus() == null ? this.status : stationFit.getStatus();
		this.rewardAmount = stationFit.getRewardAmount() == null ? this.getRewardAmount() : stationFit.getRewardAmount();
		this.rewardValue = stationFit.getRewardValue() == null ? this.rewardValue : stationFit.getRewardValue();
		this.postEndDatetime = stationFit.getPostEndDatetime() == null ? this.postEndDatetime : stationFit.getPostEndDatetime();
		this.popupSubtitle = stationFit.getPopupSubtitle() == null ? this.popupSubtitle : stationFit.getPopupSubtitle();
		this.quizAnswer = stationFit.getQuizAnswer() == null ? this.quizAnswer : stationFit.getQuizAnswer();
		this.quizHintUrl = stationFit.getQuizHintUrl() == null ? this.quizHintUrl : stationFit.getQuizHintUrl();
		this.participationGoals = stationFit.getParticipationGoals() == null ? this.participationGoals : stationFit.getParticipationGoals();
		this.participationLimitCount = stationFit.getParticipationLimitCount() == null ? this.participationLimitCount : stationFit.getParticipationLimitCount();
		this.participationType = stationFit.getParticipationType() == null ? this.participationType : stationFit.getParticipationType();
		this.buttonName = stationFit.getButtonName() == null ? this.buttonName : stationFit.getButtonName();
		this.version = stationFit.getVersion() == null ? this.version : stationFit.getVersion();
		this.etcInfo = stationFit.getEtcInfo() == null ? this.etcInfo : stationFit.getEtcInfo();
		this.osType = stationFit.getOsType() == null ? this.osType : stationFit.getOsType();
		this.waitingSeconds = stationFit.getWaitingSeconds() == null ? this.waitingSeconds : stationFit.getWaitingSeconds();
	}

	public boolean isPostPeriod() {
		return isPostPeriod(LocalDateTime.now());
	}

	public boolean isPostPeriod(LocalDateTime now) {
		if (status != Y) {
			return false;
		}

		if (postStartDatetime == null || postEndDatetime == null) {
			return false;
		}

		if (now.isBefore(postStartDatetime)) {
			return false;
		}

		if (now.isAfter(postEndDatetime)) {
			return false;
		}

		return true;
	}

	public boolean hasAnswer() {
		return StringUtils.hasText(quizAnswer);
	}

	public boolean isCorrectAnswer(String answer) {
		return this.quizAnswer.equals(answer);
	}

	public void fillDateAndTime() {
		this.postStartDate = this.postStartDatetime.toLocalDate();
		this.postEndDate = this.postEndDatetime.toLocalDate();

		this.postStartTime = LocalTime.MIN;
		this.postEndTime = LocalTime.of(23, 59, 59);
	}

	public boolean hasRewardValue() {
		return rewardValue > 0;
	}

	public void subRewardBalance(Integer value) {
		this.rewardBalance -= value;
	}

	public boolean hasRewardBalance() {
		return rewardBalance != null && rewardBalance > 0;
	}

	public void toWait() {
		progress = Progress.WAIT;
	}

	public void toOpen() {
		progress = Progress.OPEN;
	}

	public void toClose() {
		progress = Progress.CLOSE;
	}

	public enum Progress {
		WAIT, OPEN, CLOSE
	}
}
