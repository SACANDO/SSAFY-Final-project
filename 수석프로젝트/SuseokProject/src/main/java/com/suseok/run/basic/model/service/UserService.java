package com.suseok.run.basic.model.service;

import java.util.List;

import com.suseok.run.basic.model.dto.User;

public interface UserService {

	User loginUser(User user);

	List<User> search(String con);

	boolean insert(User user);

	User selectById(String userId);

	boolean update(User user);

	boolean addRival(String userId, String rivalId);

	boolean delete(String userId);

	User findId(String name, String phoneOrEmail);

	User findPwd(String name, String phoneOrEmail, String id);

	void sendNewPassword(User foundUser);
}
