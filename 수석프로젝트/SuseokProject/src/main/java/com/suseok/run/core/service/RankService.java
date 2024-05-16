package com.suseok.run.core.service;

import java.util.List;

import com.suseok.run.basic.model.dto.Group;
import com.suseok.run.core.model.dto.UserRankRecord;

public interface RankService {

	boolean insert(Record record);

	// 내 레코드 보기
	UserRankRecord selectByUser(String userId);

	// 전체 유저
	List<UserRankRecord> selectAllOrderBy(String con);

	// 내 라이벌
	List<UserRankRecord> selectAllOrderBy(String con, String userId);

	// 그룹 내
	List<UserRankRecord> selectAllOrderBy(String con, int groupId);

	// 전체그룹
	List<Group> selectGroupsOrderBy(String con);

	// 내그룹
	List<Group> selectGroupsOrderBy(String con, String userId);

	// 라이벌 상세보기
	UserRankRecord selectRival(String userId, String rivalId);

}
