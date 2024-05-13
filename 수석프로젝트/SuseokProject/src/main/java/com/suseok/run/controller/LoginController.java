package com.suseok.run.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.run.model.dto.User;
import com.suseok.run.model.service.LoginService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/login")
@Tag(name="LoginRestController", description = "로그인")
public class LoginController {


	private final LoginService ls;
	
	public LoginController(LoginService ls) {
		this.ls=ls;
	}
	
	@GetMapping("")
	public ResponseEntity<?> login(@RequestBody User user) {
			//로그인 로직
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping("/kakao")
	public ResponseEntity<?> loginKakao(@RequestBody User user) {
			//로그인 로직
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping("/naver")
	public ResponseEntity<?> loginNaver(@RequestBody User user) {
			//로그인 로직
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping("/google")
	public ResponseEntity<?> loginGoogle(@RequestBody User user) {
			//로그인 로직
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@PostMapping("/findId")
	public ResponseEntity<?> findId(@RequestBody User user) {
			//아이디 찾기 로직
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/findPwd")
	public ResponseEntity<?> findPwd(@RequestBody User user) {
			//아이디 찾기 로직
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
