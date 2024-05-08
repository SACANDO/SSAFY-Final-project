package com.suseok.run.model.dao;

import java.util.List;

import com.suseok.run.model.dto.Group;

public interface GroupDao {
	// CRUD : insert, selectAll, update, delete

	int insert(Group group);

	List<Group> selectAll();

	Group selectById(int id);

	int update(Group group);

	int delete(int id);
}
