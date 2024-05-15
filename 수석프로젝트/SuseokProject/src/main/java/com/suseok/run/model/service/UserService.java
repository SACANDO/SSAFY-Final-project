package com.suseok.run.model.service;

import java.util.List;

import com.suseok.run.model.dto.User;

public interface UserService {

	List<User> search(String con);

	boolean insert(User user);

	User selectById(String userId);

	boolean update(User user);

	boolean addRival(String userId, String rivalId);

}
