package com.suseok.run.model.service;

import org.springframework.stereotype.Service;

import com.suseok.run.model.dto.Condition;
import com.suseok.run.model.dto.Group;

@Service
public class GroupServiceImpl implements GroupService{

	@Override
	public Group search(Condition con) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Group group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean join(int groupId, String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exit(int groupId, String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Group group) {
		// TODO Auto-generated method stub
		return false;
	}

}
