package com.suseok.run.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suseok.run.model.dao.RankDao;
import com.suseok.run.model.dao.UserDao;
import com.suseok.run.model.dto.Group;
import com.suseok.run.model.dto.UserRankRecord;

@Service
public class RankServiceImpl implements RankService {

	@Autowired
	RankDao rd;
	
	@Autowired
	UserDao ud;
	

	@Override
	public List<UserRankRecord> selectAllOrderBy(String con) {
		return rd.selectAllOrderBy(con);
	}

	@Override
	public List<UserRankRecord> selectAllRivalOrderBy(String con, String userId) {
		return rd.selectAllRivalOrderBy(con, userId);
	}

	@Override
	public List<UserRankRecord> selectAllMemberOrderBy(String con, int groupId) {
		return rd.selectAllMemberOrderBy(con, groupId);
	}

	@Override
	public List<Group> selectGroupsOrderBy(String con) {
		return rd.selectGroupsOrderBy(con);
	}

	@Override
	public List<Group> selectMyGroupsOrderBy(String con, String userId) {
		return rd.selectMyGroupsOrderBy(con, userId);
	}

	@Override
	public UserRankRecord selectRival(String userId, String rivalId) {
		return rd.selectRival(userId, rivalId);
	}

	@Override
	public UserRankRecord selectByUser(String userId) {
		return rd.selectByUserId(userId);
	}


	@Override
	public boolean updateRankRecord(UserRankRecord record, int userSeq) {

		return rd.updateRankRecord(record);
	}

	@Override
	public boolean insertRankRecord(UserRankRecord record, String userId) {
		int us=ud.selectById(userId).getUserSeq();
		record.setUserSeq(us);
		UserRankRecord urr = rd.selectByUserId(userId);
		if(urr!=null) {
			
			return updateRankRecord(record, us);
		}
		return rd.insertRankRecord(record);
	}



}
