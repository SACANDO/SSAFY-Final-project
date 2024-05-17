package com.suseok.run.model.dao;

import java.util.List;

import com.suseok.run.model.dto.Group;
import com.suseok.run.model.dto.Records;
import com.suseok.run.model.dto.UserRankRecord;

public interface RankDao {

	boolean insertRecord(Records record);

	boolean insertRankRecord(UserRankRecord userRankRecord);
	
	UserRankRecord selectByUser(String userId);

	List<UserRankRecord> selectAllOrderBy(String con);

	List<Records> selectRecordsByUser(String userId);
	
	List<UserRankRecord> selectAllRivalOrderBy(String con, String userId);

	List<UserRankRecord> selectAllMemberOrderBy(String con, int groupId);

	List<Group> selectGroupsOrderBy(String con);

	List<Group> selectMyGroupsOrderBy(String con, String userId);

	UserRankRecord selectRival(String userId, String rivalId);

	boolean updateRankRecord(UserRankRecord urr);



}
