package com.suseok.run.core.model.service;

import java.util.List;

import com.suseok.run.basic.model.dto.Group;
import com.suseok.run.core.model.dto.Records;
import com.suseok.run.core.model.dto.UserBadges;
import com.suseok.run.core.model.dto.UserRankRecord;

public interface RankService {

	//현재 뛴 기록 저장
	boolean insertRecord(Records record, String userId);
	
	//처음 기록으로 rankRecord생성
	boolean insertRankRecord(UserRankRecord userRankRecord);
	
	//내 전체 기록
	List<Records> selectRecordsByUser(String userId);
	
	//내 전체 뱃지
	List<UserBadges> selectBadgesByUser(String userId);
	
	// 내 랭크레코드
	UserRankRecord selectByUser(String userId);

	// 전체 유저
	List<UserRankRecord> selectAllOrderBy(String con);

	// 내 라이벌
	List<UserRankRecord> selectAllRivalOrderBy(String con, String userId);

	// 그룹 내
	List<UserRankRecord> selectAllMemberOrderBy(String con, int groupId);

	// 전체그룹
	List<Group> selectGroupsOrderBy(String con);

	// 내그룹
	List<Group> selectMyGroupsOrderBy(String con, String userId);

	// 라이벌 상세보기
	UserRankRecord selectRival(String userId, String rivalId);

	UserRankRecord updateRankRecord(Records record, String userId);

	
}
