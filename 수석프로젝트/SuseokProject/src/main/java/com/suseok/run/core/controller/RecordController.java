package com.suseok.run.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.run.basic.jwtutill.AuthRequired;
import com.suseok.run.core.model.dto.Records;
import com.suseok.run.core.model.dto.UserBadges;
import com.suseok.run.core.model.dto.UserRankRecord;
import com.suseok.run.core.model.service.RankService;
import com.suseok.run.core.model.service.RecordsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/record")
@Tag(name = "RecordRestController", description = "기록CRUD")
public class RecordController {

	private final RecordsService rs;
	private final RankService urs;

	public RecordController(RecordsService rs, RankService urs) {
		this.rs = rs;
		this.urs = urs;
	}
	
	@AuthRequired 
	@GetMapping
	@Operation(summary = "(api필요)recordStart", description = "어떻게 구현 하지 ㅎㅋㅎㅋㅎㅋㅎㅋㅎㅋㅎ maybe need api")
	public ResponseEntity<?> recordStart() {
		// 얘는 시간 남으면 api쓰기
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@AuthRequired 
	@PostMapping
	@Operation(summary = "postRecord")
	public ResponseEntity<Record> postRecord(@RequestBody Record record, @RequestHeader("userId") String userId) {
		if (rs.insert(record))
			return new ResponseEntity<>(record,HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@AuthRequired 
	@GetMapping("/my")
	@Operation(summary = "myLog", description = "(기본) 뱃지클릭, 스트릭클릭, 프사클릭 등등")
	public ResponseEntity<Map<String, Object>> myLog(@RequestHeader("userId") String userId) {

		Map<String, Object> res = new HashMap<>();

		UserRankRecord userRankRecord = urs.selectByUser(userId);
		
		List<Records> records = rs.selectAllByUser(userId);
		
		List<UserBadges> userBadges = rs.selectBadgesByUser(userId);

		if (userRankRecord == null && records == null && userBadges == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		res.put("records", records);
		res.put("userRankRecord", userRankRecord);
		res.put("userBadges", userBadges);

		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
	}

}
