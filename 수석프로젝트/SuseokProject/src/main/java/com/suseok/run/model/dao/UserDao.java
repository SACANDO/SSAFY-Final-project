package com.suseok.run.model.dao;

import java.util.List;

import com.suseok.run.model.dto.User;

public interface UserDao {
	// CRUD : insert, selectAll, update, delete
	int insert(User user);

	List<User> selectAll();

	int update(User user);

	int delete(int userSeq);

}
