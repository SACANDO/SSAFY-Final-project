package com.suseok.run.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.suseok.run.basic.model.dto.Group;
import com.suseok.run.core.model.dto.UserRankRecord;

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
