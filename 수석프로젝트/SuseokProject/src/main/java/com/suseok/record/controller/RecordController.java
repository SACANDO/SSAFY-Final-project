package com.suseok.record.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.record.service.BadgeService;
import com.suseok.record.service.RecordsService;
import com.suseok.record.service.UserRecordService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/record")
@Tag(name="RecordRestController", description = "기록CRUD")
public class RecordController {
	
	private final RecordsService rs;
	private final UserRecordService urs;
	private final BadgeService bs;
	
	public RecordController(RecordsService rs, UserRecordService urs, BadgeService bs) {
		this.rs=rs;
		this.urs=urs;
		this.bs=bs;
	}

	@GetMapping
	@Operation(summary="기록", description = "어떻게 구현 하지 ㅎㅋㅎㅋㅎㅋㅎㅋㅎㅋㅎ maybe need api")
	public ResponseEntity<?> recordStart() {
		//얘는 어떻게 하지?
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	@Operation(summary="기록 종료 및 저장")
	public ResponseEntity<?> postRecord(@RequestBody Record record) {
		if(rs.insert(record))
		return new ResponseEntity<>(HttpStatus.CREATED);
		else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	

	@GetMapping("/my")
	@Operation(summary = "내 로그", description = "(기본) 뱃지클릭, 스트릭클릭, 프사클릭 등등")
	public ResponseEntity<?> myRecord() {
			//urs.selectByUser(userSeq)
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/recent")
	@Operation(summary = "최근활동")
	public ResponseEntity<?> recentRecord() {
			//rs.selectByUser(userSeq)
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/badge")
	@Operation(summary = "뱃지로그")
	public ResponseEntity<?> badgeRecord() {
			//bs.selectByUser(userSeq)
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
