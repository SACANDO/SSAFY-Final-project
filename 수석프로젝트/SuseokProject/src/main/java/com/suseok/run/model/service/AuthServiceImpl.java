package com.suseok.run.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suseok.run.model.dao.AuthDao;
import com.suseok.run.model.dto.User;

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
