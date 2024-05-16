package com.suseok.run.basic.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.run.basic.jwt.JwtUtil;
import com.suseok.run.basic.model.dto.User;
import com.suseok.run.basic.model.service.AuthService;
import com.suseok.run.basic.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping({ "", "/" })
@Tag(name = "(5/16)AuthRestController", description = "Authentication")
public class AuthController {



	private final AuthService as;
	private final UserService us;
	private final JwtUtil jwtUtil;

	public AuthController(AuthService as, UserService us, JwtUtil jwtUtil) {
		this.as = as;
		this.us = us;
		this.jwtUtil = jwtUtil;
	}

	@PostMapping("/login")
	@Operation(summary = "login")
	public ResponseEntity<?> login(@RequestBody User user, HttpServletResponse response)
			throws UnsupportedEncodingException {
		Map<String, Object> result = as.login(user, response);

		if (result.containsKey("message")) {
			return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/logout")
	@Operation(summary = "logout")
	public ResponseEntity<?> logout(@RequestHeader("userId") String userId, HttpServletResponse response) {
		as.invalidateToken(userId, response);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/signup")
	@Operation(summary = "signup")
	public ResponseEntity<?> signup(@RequestBody User user) {
		if (us.insert(user))
			return new ResponseEntity<>(HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/signup/{checkId}")
	@Operation(summary = "checkId")
	public ResponseEntity<?> checkId(@RequestParam String checkId) {
		if (us.selectById(checkId) != null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/withdraw")
	@Operation(summary = "withdraw")
	public ResponseEntity<?> withdraw(@RequestHeader("userId") String userId) {
		// 로그아웃도 같이 하기
		// user와 관련된 모든 것들 다지워...

		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/kakao")
	@Operation(summary = "loginKakao")
	public ResponseEntity<?> loginKakao(@RequestBody User user) {
		// 로그인 로직
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/naver")
	@Operation(summary = "loginNaver")
	public ResponseEntity<?> loginNaver(@RequestBody User user) {
		// 로그인 로직
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/google")
	@Operation(summary = "loginGoogle")
	public ResponseEntity<?> loginGoogle(@RequestBody User user) {
		// 로그인 로직
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/findId")
	@Operation(summary = "findId")
	public ResponseEntity<?> findId(@RequestBody User user) {
		// 아이디 찾기 로직
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/findPwd")
	@Operation(summary = "findPwd")
	public ResponseEntity<?> findPwd(@RequestBody User user) {
		// 아이디 찾기 로직
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
