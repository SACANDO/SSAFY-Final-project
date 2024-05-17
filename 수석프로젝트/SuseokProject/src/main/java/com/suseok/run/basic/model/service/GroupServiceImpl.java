package com.suseok.run.basic.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suseok.run.basic.model.dao.GroupDao;
import com.suseok.run.basic.model.dao.UserDao;
import com.suseok.run.basic.model.dto.Group;
import com.suseok.run.basic.model.dto.User;
import com.suseok.run.core.model.dao.RankDao;
import com.suseok.run.core.model.dto.UserRankRecord;

@Service
public class GroupServiceImpl implements GroupService{

	
	@Autowired
	GroupDao gd;
	
	@Autowired
	RankDao rd;
	
	@Autowired
	UserService us;
	

	
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
		//자격이 되는 사람만가능
		Group group=gd.selectById(groupId);
		UserRankRecord urr = rd.selectByUser(userId);
		
		if(urr.getFrequency() !=0 && urr.getFrequency()>group.getConFrequency()) return false;
		if(urr.getHighestPace()!=0 && urr.getHighestPace()>group.getConPace()) return false;
		if(urr.getTotalDistance()!=0 && urr.getTotalDistance()<group.getConTotalDistance()) return false;
		
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
