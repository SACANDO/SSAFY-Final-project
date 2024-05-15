package com.suseok.record.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.suseok.record.model.dto.UserRankRecord;
import com.suseok.run.model.dto.Group;

@Service
public class RankServiceImpl implements RankService {

	@Override
	public boolean insert(Record record) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserRankRecord> selectAllOrderBy(String con) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRankRecord> selectAllOrderBy(String con, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRankRecord> selectAllOrderBy(String con, int groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> selectGroupsOrderBy(String con) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> selectGroupsOrderBy(String con, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRankRecord selectRival(String userId, String rivalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRankRecord selectByUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
