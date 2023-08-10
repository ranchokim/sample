package com.neibus.model.member;

import static com.neibus.common.domain.enumable.EnumErrorCode.*;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neibus.common.domain.CommonFile;
import com.neibus.common.exception.ClientException;
import com.neibus.common.util.FileUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idx;
	private String email;
	private String nick;
	private String name;
	private String birthday;
	private String sex;
	private String maritalStatus;
	private int favoriteBusIdx;
	private String uniqueCode;
	private String recommenderCode;
	private String snsNo;
	private String snsTypeCode;
	private int fileIdx = 0;
	private String regDt;
	private String dropDt;
	private String dropTypeCode;
	private String cityCode;
	private String status;
	private String agree1;
	private String agree2;
	private String agree3;
	private String agree4;
	private String agree5;
	private String agreeDt;
	private String di;
	private String ci;
	private String ci2;
	private String telComCd;
	private String ciUpdate;
	private String ntvFrnrCd;
	private String accessToken;
	private String blockDt;
	private EnumMemberBlockType blockTypeCode;
	private String mobileNo;
	private Integer appVersion;
	private OsType osType;
	private String mdLinkStatus;
	private String mydataUser;

	private CommonFile commonFile;
	private CommonFile snsFile;

	private String profileImageUrl;
	private String snsProfileFlag;
	private int reviewCnt;
	private int communityCnt;
	private int fromDt;
	private String me;
	private String userNm;
	private String address;
	private int targetIdx;
	private String category;
	private int pt2Cnt;
	private ErrorCode errorCode;
	private NeiBus neiBus;
	private Version version;
	private int callCnt;
	private double dice;
	private int highRewardCount;
	private LocalDateTime mergedAt;
	private Integer mainIdx;
	private Integer subIdx;
	private Integer recommenderIdx;
	private LocalDateTime lastAccessDt;
	private LocalDateTime holdDt;

	public Member(int idx) {
		this.idx = idx;
	}

	public Member() {
	}

	public Member(String accessToken) {
		this.accessToken = accessToken;
	}

	public LocalDateTime regDtConvertToLocalDateTime() {
		return LocalDateTime.parse(regDt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public LocalDate regDtConvertToLocalDate() {
		return regDtConvertToLocalDateTime().toLocalDate();
	}

	public boolean isWin(Double chance) {
		return this.dice < chance;
	}

	public void castDice() {
		this.dice = Math.random();
	}

	public boolean isHighRewarder() {
		return highRewardCount > 0;
	}

	public boolean hasCI() {
		return StringUtils.hasText(ci);
	}

	public boolean isExist() {
		return idx > 0;
	}

	@JsonIgnore
	public boolean isAgreeTermsOfMydata() {
		if (StringUtils.isEmpty(agree5)) {
			return false;
		}

		return agree5.equals("Y");
	}

	@JsonIgnore
	public boolean isMatchCi(String decryptCertId) {
		if (StringUtils.isEmpty(this.ci)) {
			return false;
		}

		return this.ci.equals(decryptCertId);
	}

	public boolean isMyDataUser() {
    return "Y".equals(mydataUser);
  }

  public String makeProfilePath() {
    if (commonFile == null) {
      return File.separator + "MEMBER" + File.separator + "profile_default_200917.png";
    }

    return commonFile.makeFullPath();
  }

  /**
   * 프로필 이미지 불러오기
   */
  public void loadProfileImage(FileUtil fileUtil) {
    profileImageUrl = fileUtil.makeImageUrl(makeProfilePath());
  }

	public boolean hasRecommender() {
		return recommenderCode.length() > 0;
	}

	@JsonIgnore
	public boolean isActiveUser() {
		return status.equals("Y");
	}

	public boolean equalsVersion(int appVersion) {
		if (this.appVersion == null) {
			return false;
		}

		return this.appVersion.equals(appVersion);
	}

	public void deleteCertData() {
		this.name = null;
		this.birthday = null;
		this.sex = null;
		this.mobileNo = null;
		this.ci = null;
		this.ci2 = null;
		this.ciUpdate = null;
		this.di = null;
		this.ntvFrnrCd = null;
		this.telComCd = null;
	}

	public void merge(Member sub) {
		this.subIdx = sub.idx;
		this.mergedAt = LocalDateTime.now();

		sub.mainIdx = this.idx;
		sub.status = "M";
		sub.mergedAt = LocalDateTime.now();
	}

	public boolean isMergeable() {
	  if (mainIdx == null && subIdx == null) {
		  return true;
	  }

	  return LocalDate.now().isAfter(mergedAt.toLocalDate().plusDays(30));
	}

	public void checkMergePolicy() {
		if (isMergeable()) {
			return;
		}

		throw new ClientException.Conflict(MERGE_POLICY);
	}

	@JsonIgnore
	public boolean isDropped() {
		return status.equals("N") && dropDt != null;
	}

	public Sex convertSex() {
		if (this.sex == null || this.sex.isEmpty()) {
			return Sex.UNDEFINED;
		}

		return Sex.valueOf(this.sex);
	}

	@JsonIgnore
	public Integer getAgeGroup() {
		if (birthday == null || birthday.isEmpty()) {
			return 0;
		}

		int birthYear = Integer.parseInt(birthday.substring(0, 4));
		int age = LocalDate.now().getYear() - birthYear + 1;

		return (int)Math.floor(age / 10) * 10;
	}

	public Member(InactiveMember inactiveMember) {
	  this.idx = inactiveMember.getMemberIdx();
	  this.email = inactiveMember.getEmail();
	  this.nick = inactiveMember.getNick();
	  this.name = inactiveMember.getName();
	  this.status = "Y";
	  this.birthday = inactiveMember.getBirthday();
	  this.sex = inactiveMember.getSex();
	  this.ci = inactiveMember.getCi();
	  this.ci2 = inactiveMember.getCi2();
	  this.telComCd = inactiveMember.getTelComCd();
	  this.ciUpdate = inactiveMember.getCiUpdate();
	  this.ntvFrnrCd = inactiveMember.getNtvFrnrCd();
	  this.accessToken = inactiveMember.getAccessToken();
	  this.mobileNo = inactiveMember.getMobileNo();
	  this.mdLinkStatus = inactiveMember.getMdLinkStatus();
	  this.mydataUser = inactiveMember.getMyDataUser();
	  this.regDt = inactiveMember.getRegDt();
	}
}
