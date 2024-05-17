package com.suseok.run.core.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suseok.run.basic.model.dto.Group;
import com.suseok.run.core.model.dao.RankDao;
import com.suseok.run.core.model.dto.Records;
import com.suseok.run.core.model.dto.UserBadges;
import com.suseok.run.core.model.dto.UserRankRecord;

@Service
public class RankServiceImpl implements RankService {

	
	@Autowired
	RankDao rd;

	@Override
	public boolean insertRecord(Records record, String userId) {
		//
		UserRankRecord urr= updateRankRecord(record, userId);
		return rd.insertRecord(record);
	}



	@Override
	public List<UserBadges> selectBadgesByUser(String userId) {
		return rd.selectBadgesByUser(userId);
	}


	@Override
	public List<UserRankRecord> selectAllOrderBy(String con) {
		return rd.selectAllOrderBy(con);
	}

	@Override
	public List<UserRankRecord> selectAllRivalOrderBy(String con, String userId) {
		return rd.selectAllRivalOrderBy(con,userId);
	}

	@Override
	public List<UserRankRecord> selectAllMemberOrderBy(String con, int groupId) {
		return rd.selectAllMemberOrderBy(con,groupId);
	}

	@Override
	public List<Group> selectGroupsOrderBy(String con) {
		return rd.selectGroupsOrderBy(con);
	}

	@Override
	public List<Group> selectMyGroupsOrderBy(String con, String userId) {
		return rd.selectMyGroupsOrderBy(con,userId);
	}

	@Override
	public UserRankRecord selectRival(String userId, String rivalId) {
		return rd.selectRival(userId,rivalId);
	}

	@Override
	public UserRankRecord selectByUser(String userId) {
		return rd.selectByUser(userId);
	}

	@Override
	public boolean insertRankRecord(UserRankRecord userRankRecord) {
		return rd.insertRankRecord(userRankRecord);
	}

	@Override
	public List<Records> selectRecordsByUser(String userId) {
		return rd.selectRecordsByUser(userId);
	}


	@Override
	public UserRankRecord updateRankRecord(Records record, String userId) {
		
		UserRankRecord urr = rd.selectByUser(userId);
		
		//빈도
		//누적거리
		//pace
		
		return rd.updateRankRecord(urr);
	}

}
