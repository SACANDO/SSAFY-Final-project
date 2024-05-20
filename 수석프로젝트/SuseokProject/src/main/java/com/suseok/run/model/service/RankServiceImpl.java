package com.suseok.run.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suseok.run.model.dao.RankDao;
import com.suseok.run.model.dao.RecordDao;
import com.suseok.run.model.dto.Group;
import com.suseok.run.model.dto.Record;
import com.suseok.run.model.dto.UserRankRecord;

@Service
public class RankServiceImpl implements RankService {

	@Autowired
	RankDao rd;
	
	@Autowired
	RecordDao red;

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
	public boolean insertRankRecord(UserRankRecord userRankRecord) {
		return rd.insertRankRecord(userRankRecord);
	}

	@Override
	public boolean updateRankRecord(Record record, int userSeq) {

		
		List<Record> records = red.selectRecordsByUserSeq(userSeq);
		UserRankRecord urr = rd.selectByUserSeq(userSeq);

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
