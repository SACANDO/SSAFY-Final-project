package com.suseok.run.model.dao;

import java.util.List;

import com.suseok.run.model.dto.Group;
import com.suseok.run.model.dto.User;

public interface GroupMemberInfoDao {
	// CRUD : insert, selectAll, update, delete

	int insert(int groupId, int userSeq);
	
	//그룹에 따라 user 전부
	List<User> selectUsers()
	
	//user에 따라 그룹 전부
}
