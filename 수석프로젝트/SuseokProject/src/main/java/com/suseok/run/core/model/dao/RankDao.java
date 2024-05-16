package com.suseok.run.core.model.dao;

import java.util.List;

import com.suseok.run.basic.model.dto.Group;
import com.suseok.run.core.model.dto.Records;
import com.suseok.run.core.model.dto.UserBadges;
import com.suseok.run.core.model.dto.UserRankRecord;

public interface RankDao {

	boolean insertRecord(Records record);

	boolean insertRankRecord(UserRankRecord userRankRecord);

	List<Records> selectRecordsByUser(String userId);

	List<UserBadges> selectBadgesByUser(String userId);

	UserRankRecord selectByUser(String userId);

	List<UserRankRecord> selectAllOrderBy(String con);

	List<UserRankRecord> selectAllRivalOrderBy(String con, String userId);

	List<UserRankRecord> selectAllMemberOrderBy(String con, int groupId);

	List<Group> selectGroupsOrderBy(String con);

	List<Group> selectMyGroupsOrderBy(String con, String userId);

	UserRankRecord selectRival(String userId, String rivalId);

	UserRankRecord updateRankRecord(UserRankRecord urr);


}
