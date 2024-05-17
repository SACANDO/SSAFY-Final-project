package com.suseok.run.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suseok.run.model.dao.RankDao;
import com.suseok.run.model.dto.Group;
import com.suseok.run.model.dto.Records;
import com.suseok.run.model.dto.UserRankRecord;

@Service
public class RankServiceImpl implements RankService {

	@Autowired
	RankDao rd;

	@Override 
	public boolean insertRecord(Records record, String userId) {

		updateRankRecord(record, userId);
		return rd.insertRecord(record);
	}


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
	public boolean updateRankRecord(Records record, String userId) {

		
		List<Records> records = rd.selectRecordsByUser(userId);
		UserRankRecord urr = rd.selectByUser(userId);

		// 빈도
		urr.setFrequency(urr.getFrequency()+1);
		// 누적거리
		urr.setTotalDistance(record.getDistance());
		// pace
		int totalTime=0;
		for(int i =0; i<records.size(); i++) {
			totalTime+=records.get(i).getRunTime();
		}
		
		urr.setHighestPace(totalTime/urr.getTotalDistance());

		return rd.updateRankRecord(urr);
	}


}
