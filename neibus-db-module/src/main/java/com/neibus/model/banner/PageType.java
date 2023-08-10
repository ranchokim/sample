package com.neibus.model.banner;

import lombok.Getter;

@Getter
public enum PageType implements EnumType {

	BUS_MAIN("버스 - 메인"),
	BUS_BUS("버스 - 노선"),
	BUS_REVIEW("버스 - 리뷰"),
	BUS_STATION("버스 - 정류장"),
	BUS_FITAD("버스 - 정류장핏"),
	COMMUNITY_MAIN("커뮤니티 - 메인"),
	COMMUNITY_WRITING("커뮤니티 - 글 상세"),
	COUPON_POSSESSION("쿠폰함 - 보유쿠폰"),
	COUPON_USED("쿠폰함 - 사용내역"),
	CUSTOMERCENTER_MAIN("고객센터 - 메인"),
	CUSTOMERCENTER_CHAT("고객센터 - 채팅상담"),
	CUSTOMERCENTER_INQUIRY("고객센터 - 1:1문의"),
	ENTRY_MAIN("응모 - 메인"),
	ENTRY_CONDITION("응모 - 나의응모현황 - 진행중"),
	ENTRY_CONDITION_CLOSE("응모 - 나의응모현황 - 마감"),
	MARKET_MAIN("마켓 메인"),
	MYTOKEN_GENERAL("마이네이토큰 - 전체내역"),
	MYTOKEN_EXPITATION("마이네이토큰 - 소멸예정"),
	NOTICE_MAIN("공지사항 메인"),
	NOTICE_WRITING("공지사항 글 상세"),
	ROULETTE_MAIN("출석체크 메인"),
	ROULETTE_STATUS("출석현황"),
	SUBWAY_BUSAN("부산 노선도"),
	SUBWAY_CAPITAL("수도권 노선도"),
	SUBWAY_DAEGU("대구 노선도"),
	SUBWAY_DAEJEON("대전 노선도"),
	SUBWAY_GWANGJU("광주 노선도"),
	SUBWAY_STATION("지하철역"),
	CHALLENGE_MAIN("친환경챌린지 - 메인"),
	CHALLENGE_DETAIL("친환경챌린지 - 상세"),
	CHALLENGE_CONDITION("친환경챌린지 - 나의참여현황"),
	CHALLENGE_GUIDE("친환경챌린지 - 안내"),
	QUIZ_MAIN("정류장퀴즈 - 메인"),
	DROP_MAIN("정류장드롭 - 메인"),
	PM_MAIN("자전거 - 메인"),
	;

	private String value;

	PageType(String value) {
		this.value = value;
	}

	@Override
	public String getCode() {
		return name();
	}
}
