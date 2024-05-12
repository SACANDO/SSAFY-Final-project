package com.suseok.run.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.run.model.dto.Condition;
import com.suseok.run.model.dto.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping({"/",""})
@Tag(name="MainController")
public class MainController {
	
	@GetMapping
	@Operation(summary="메인 페이지")
	public ResponseEntity<?> main() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/signup")
	@Operation(summary = "회원가입버튼")
	public ResponseEntity<?> signupButton() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	@Operation(summary = "회원가입")
	public ResponseEntity<?> signup(@RequestBody User user) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/logout")
	@Operation(summary="로그아웃")
	public ResponseEntity<?> logout() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PostMapping("/search/user")
	@Operation(summary = "유저 찾기")
	public ResponseEntity<?> searchById(@RequestBody Condition con) {
			
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/search/group")
	@Operation(summary="그룹 검색")
	public ResponseEntity<?> searchGroup(@RequestBody Condition con) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
