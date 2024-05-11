package com.suseok.run.model.dao;

import java.util.List;

import com.suseok.run.model.dto.Condition;
import com.suseok.run.model.dto.User;

public interface UserDao {
	// CRUD : insert, selectAll, update, delete
	int insert(User user);

	List<User> selectAll();
	
	User selectByUserSeq(int userSeq);

	int update(User user);

	int delete(int userSeq);
	
	List<User> search(Condition con);

}
