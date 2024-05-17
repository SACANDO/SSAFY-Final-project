package com.suseok.run.basic.model.dao;

import java.util.List;


import com.suseok.run.basic.model.dto.User;

public interface UserDao {
	// CRUD : insert, selectAll, update, delete
	boolean insert(User user);

	List<User> selectAll();

	User selectById(String userId);

	boolean update(User user);

	boolean delete(String userId);

	List<User> search(String con);

	boolean addRival( String userId, String rivalId); //질문!

	User findId(String name, String phoneOrEmail);

	User findPwd(String name, String phoneOrEmail, String id);

	User loginUser(User user);
	
	

	

	
	

}
