package com.suseok.run.basic.model.service;

import java.util.Map;

import com.suseok.run.basic.model.dto.User;

import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {

	Map<String, Object> login(User user, HttpServletResponse response);

	void invalidateToken(String userId, HttpServletResponse response);

}
