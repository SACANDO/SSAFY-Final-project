package com.suseok.run.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.run.model.dto.Condition;
import com.suseok.run.model.dto.Group;
import com.suseok.run.model.dto.User;
import com.suseok.run.model.service.GroupService;
import com.suseok.run.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping({ "/", "" })
@Tag(name = "MainController")
public class MainController {

	private final UserService us;
	private final GroupService gs;

	public MainController(UserService us, GroupService gs) {
		this.gs = gs;
		this.us = us;
	}



	@PostMapping("/signup")
	@Operation(summary = "회원가입")
	public ResponseEntity<?> signup(@RequestBody User user) {
		if (us.insert(user))
			return new ResponseEntity<>(HttpStatus.CREATED);
		else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	

	@PostMapping("/search/user")
	@Operation(summary = "유저 찾기")
	public ResponseEntity<User> searchUser(@RequestBody Condition con) {
		User user = us.search(con);
		if (user != null)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/search/group")
	@Operation(summary = "그룹 검색")
	public ResponseEntity<Group> searchGroup(@RequestBody Condition con) {
		Group group = gs.search(con);
		if (group != null)
			return new ResponseEntity<Group>(group, HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
