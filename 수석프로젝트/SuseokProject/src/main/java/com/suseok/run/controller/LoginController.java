package com.suseok.run.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.jwt.JwtUtil;
import com.suseok.run.model.dto.User;
import com.suseok.run.model.service.LoginService;
import com.suseok.run.model.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/login")
@Tag(name = "LoginRestController", description = "로그인")
public class LoginController {

	@Value("${jwt.refreshtoken.expiretime}")
	private int refreshTokenExpireTime;

	private final LoginService ls;
	private final UserService us;
	private final JwtUtil jwtUtil;
	

	public LoginController(LoginService ls, UserService us, JwtUtil jwtUtil) {
		this.ls = ls;
		this.us = us;
		this.jwtUtil = jwtUtil;
	}

	@PostMapping
	public ResponseEntity<?> login(@RequestBody User user, HttpServletResponse response)
			throws UnsupportedEncodingException {

		Map<String, Object> result = new HashMap<>();

		User dbUser = ls.loginUser(user);

		if (dbUser == null) {
			result.put("message", "일치하는 유저가 없습니다.");
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.UNAUTHORIZED);
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

		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}

	@PostMapping("/kakao")
	public ResponseEntity<?> loginKakao(@RequestBody User user) {
		// 로그인 로직
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/naver")
	public ResponseEntity<?> loginNaver(@RequestBody User user) {
		// 로그인 로직
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/google")
	public ResponseEntity<?> loginGoogle(@RequestBody User user) {
		// 로그인 로직
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/findId")
	public ResponseEntity<?> findId(@RequestBody User user) {
		// 아이디 찾기 로직
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/findPwd")
	public ResponseEntity<?> findPwd(@RequestBody User user) {
		// 아이디 찾기 로직
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
