package com.suseok.run.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.run.model.dto.SearchCondition;
import com.suseok.run.model.dto.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user")
@Tag(name="UserRestController", description = "유저CRUD")
public class UserController {
	
	@GetMapping("/{userId}")
	@Operation(summary = "마이페이지")
	public ResponseEntity<?> mypage(@PathVariable ("userId") int userId) {
			
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{userId}")
	@Operation(summary = "내정보 수정")
	public ResponseEntity<?> updateMypage(@PathVariable ("userId") int userId, @RequestBody User user) {
			
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	@Operation(summary = "탈퇴")
	public ResponseEntity<?> withdraw(@PathVariable ("userId") int userId) {
			
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/search")
	@Operation(summary = "유저 찾기")
	public ResponseEntity<?> searchById(@RequestBody SearchCondition con) {
			
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

	
	
}
