package com.suseok.run.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.run.model.dto.Condition;
import com.suseok.run.model.dto.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user")
@Tag(name="UserRestController", description = "유저CRUD")
public class UserController {
	
	@GetMapping
	@Operation(summary = "마이페이지")
	public ResponseEntity<?> mypage() {
			
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
			//탈퇴한 멤버 정보는 1개월간 보관?
		
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	

	@GetMapping("/add/{rivalSeq}")
	@Operation(summary = "라이벌추가")
	public ResponseEntity<?> addRival(@PathVariable ("rivalSeq") int rivalSeq) {
			
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
