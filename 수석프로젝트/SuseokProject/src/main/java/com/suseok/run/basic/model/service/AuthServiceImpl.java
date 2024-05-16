package com.suseok.run.basic.model.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.suseok.run.basic.jwt.JwtUtil;
import com.suseok.run.basic.model.dto.User;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthServiceImpl implements AuthService {

	@Value("${jwt.refreshtoken.expiretime}")
	private int refreshTokenExpireTime;
	
	private final JwtUtil jwtUtil;
	private final UserService us;

	public AuthServiceImpl(JwtUtil jwtUtil, UserService us) {
	        this.jwtUtil = jwtUtil;
	        this.us = us;
	    }

	public Map<String, Object> login(User user, HttpServletResponse response) {
		Map<String, Object> result = new HashMap<>();

		User dbUser = us.loginUser(user);

		if (dbUser == null) {
			return null; // 유저가 존재하지 않는 경우 null 반환
		}

		String accessToken = jwtUtil.createAccessToken(dbUser.getUserId());
		String refreshToken = jwtUtil.createRefreshToken(dbUser.getUserId());

		Cookie cookie = new Cookie("refreshToken", refreshToken);
		cookie.setMaxAge(refreshTokenExpireTime);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		response.addCookie(cookie);

		result.put("accessToken", accessToken);
		result.put("userId", dbUser.getUserId());

		return result; // 유저가 존재하는 경우 결과 반환
	}

	public void invalidateToken(String userId, HttpServletResponse response) {
		// 쿠키에서 refreshToken 삭제
		Cookie cookie = new Cookie("refreshToken", null);
		cookie.setMaxAge(0);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		response.addCookie(cookie);

		// 서버 측에서 refreshToken을 무효화하는 작업
		jwtUtil.invalidateToken(userId);
	}

}
