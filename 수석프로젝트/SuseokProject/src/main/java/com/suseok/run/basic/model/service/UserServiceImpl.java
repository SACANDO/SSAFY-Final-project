package com.suseok.run.basic.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suseok.run.basic.model.dao.UserDao;
import com.suseok.run.basic.model.dto.User;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserDao ud;

	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean insert(User user) {
		return ud.insert(user);
	}

	@Override
	public User selectById(String userId) {
		return ud.selectById(userId);
	}

	@Override
	public boolean update(User user) {
		return ud.update(user);
	}

	@Override
	public boolean addRival(String userId, String rivalId) {
		return ud.addRival(userId,rivalId);
	}

	@Override
	public List<User> search(String con) {
		return ud.search(con);
	}


}
