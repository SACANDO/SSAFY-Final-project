package com.suseok.run.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.jwt.JwtUtil;
import com.suseok.run.model.dto.User;
import com.suseok.run.model.service.LoginService;
import com.suseok.run.model.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@Tag(name = "UserRestController", description = "유저CRUD")
public class UserController {

	private final LoginService ls;
	private final UserService us;
	private final JwtUtil jwtUtil;
	

	public UserController(LoginService ls, UserService us, JwtUtil jwtUtil) {
		this.ls = ls;
		this.us = us;
		this.jwtUtil = jwtUtil;
	}

	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	
	// 내일~~~~~~~
	@GetMapping("/logout")
	@Operation(summary = "로그아웃")
	public ResponseEntity<?> logout() {
		// deletemapping인가??????????
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	@Operation(summary = "마이페이지", description = "유저 정보")
	public ResponseEntity<?> mypage(HttpServletRequest request) {
		
		Jws<Claims> claims= (Jws<Claims>) request.getAttribute("claims");
		System.out.println(claims);
//		String userId = clai
		
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping
	@Operation(summary = "내정보 수정")
	public ResponseEntity<?> updateMypage(@RequestBody User user) {

		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping
	@Operation(summary = "탈퇴")
	public ResponseEntity<?> withdraw() {
		// 탈퇴한 멤버 정보는 1개월간 보관?

		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/add/{rivalSeq}")
	@Operation(summary = "라이벌추가")
	public ResponseEntity<?> addRival(@PathVariable("rivalSeq") int rivalSeq) {

		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
