package com.suseok.record.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/record")
@Tag(name="RecordRestController", description = "기록CRUD")
public class RecordController {
	
	@GetMapping
	@Operation(summary="기록시작버튼")
	public ResponseEntity<?> recordStart() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	@Operation(summary="기록종료버튼")
	public ResponseEntity<?> recordEnd(@RequestBody Record record) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	@GetMapping("/my")
	@Operation(summary = "내 로그", description = "(기본) 뱃지클릭, 스트릭클릭, 프사클릭 등등")
	public ResponseEntity<?> myRecord() {
			
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/recent")
	@Operation(summary = "최근활동")
	public ResponseEntity<?> recentRecord() {
			
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/badge")
	@Operation(summary = "뱃지로그")
	public ResponseEntity<?> badgeRecord() {
			
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
