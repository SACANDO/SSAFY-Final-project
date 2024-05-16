package com.suseok.run.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.suseok.run.core.model.dto.Records;
import com.suseok.run.core.model.dto.UserBadges;

@Service
public class RecordsServiceImpl implements RecordsService {

	@Override
	public boolean insert(Record record) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Records> selectAllByUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBadges> selectBadgesByUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
