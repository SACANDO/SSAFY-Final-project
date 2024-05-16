package com.suseok.run.basic.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suseok.run.basic.model.dao.GroupDao;
import com.suseok.run.basic.model.dto.Group;

@Service
public class GroupServiceImpl implements GroupService{

	
	@Autowired
	GroupDao gd;
	
	@Override
	public List<Group> search(String con) {
		return gd.search(con);
	}

	@Override
	public boolean insert(Group group) {
		return gd.insert(group);
	}

	@Override
	public boolean join(int groupId, String userId) {
		return gd.join(groupId,userId);
	}

	@Override
	public boolean exit(int groupId, String userId) {
		return gd.exit(groupId,userId);
	}

	@Override
	public boolean update(Group group) {
		return gd.update(group);
	}

	@Override
	public boolean kickOut(int groupId, int memberId) {
		return gd.deleteMember(groupId,memberId);
	}

}
