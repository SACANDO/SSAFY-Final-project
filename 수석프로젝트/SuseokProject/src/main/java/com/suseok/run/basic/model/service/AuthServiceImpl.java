package com.suseok.run.basic.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suseok.run.basic.model.dao.AuthDao;
import com.suseok.run.basic.model.dto.User;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	AuthDao ad;
	
	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
