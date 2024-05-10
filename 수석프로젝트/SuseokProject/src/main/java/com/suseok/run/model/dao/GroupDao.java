package com.suseok.run.model.dao;

import java.util.List;

import com.suseok.run.model.dto.Group;
import com.suseok.run.model.dto.SearchCondition;

public interface GroupDao {
	// CRUD : insert, selectAll, update, delete

	int insert(Group group);

	List<Group> selectAll();

	Group selectById(int groupId);

	int update(Group group);

	int delete(int id);
	
	List<Group> search(String groupName);
}
