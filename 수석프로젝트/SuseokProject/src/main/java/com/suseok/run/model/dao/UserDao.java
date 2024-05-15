package com.suseok.run.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suseok.run.model.dto.User;

public interface UserDao {
	// CRUD : insert, selectAll, update, delete
	boolean insert(User user);

	List<User> selectAll();

	User selectById(String userId);

	boolean update(User user);

	int delete(int userSeq);

	List<User> search(String con);

	boolean addRival( String userId, String rivalId); //질문!

}
