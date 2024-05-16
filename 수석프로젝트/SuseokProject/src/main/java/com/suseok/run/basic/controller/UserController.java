package com.suseok.run.basic.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.run.basic.model.dto.User;
import com.suseok.run.basic.model.service.AuthService;
import com.suseok.run.basic.model.service.UserService;
import com.suseok.run.jwt.JwtUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user")
@Tag(name = "(완료)UserRestController", description = "유저CRUD")
public class UserController {

	private final UserService us;
	private final JwtUtil jwtUtil;

	public UserController(UserService us, JwtUtil jwtUtil) {
		this.us = us;
		this.jwtUtil = jwtUtil;
	}

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@GetMapping
	@Operation(summary = "myPage", description = "유저 정보")
	public ResponseEntity<User> myPage(@RequestHeader("userId") String userId) {

		User user = us.selectById(userId);

		if (user != null)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping
	@Operation(summary = "updateMyPage")
	public ResponseEntity<?> updateMyPage(@RequestHeader("userId") String userId, @RequestBody User user) {
		if (userId != user.getUserId())
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		if (us.update(user))
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping("/add/{rivalId}")
	@Operation(summary = "addRival")
	public ResponseEntity<?> addRival(@RequestHeader("userId") String userId, @PathVariable("rivalId") String rivalId) {

		if (us.addRival(userId, rivalId))
			return new ResponseEntity<>(HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/search")
	@Operation(summary = "searchUser")
	public ResponseEntity<List<User>> searchUser(@RequestParam String con) {
		List<User> users = us.search(con);
		if (users != null)
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
