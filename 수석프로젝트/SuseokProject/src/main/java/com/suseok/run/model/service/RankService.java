package com.suseok.run.model.service;

import java.util.List;

import com.suseok.run.model.dto.Group;
import com.suseok.run.model.dto.Record;
import com.suseok.run.model.dto.UserRankRecord;

public interface RankService {


	//처음 기록으로 rankRecord생성
	boolean insertRankRecord(UserRankRecord userRankRecord);
	
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

	boolean updateRankRecord(Record record, int userSeq);


	
}
