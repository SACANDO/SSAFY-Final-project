package com.suseok.record.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.run.model.dto.User;
import com.suseok.run.model.service.GroupService;
import com.suseok.run.model.service.UserService;

import ch.qos.logback.core.joran.conditional.Condition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rank")
@Tag(name = "RankRestController", description = "랭킹R")
public class RankController {

	private final UserService us;
	private final GroupService gs;

	public RankController(UserService us,GroupService gs) {
		this.us=us;
		this.gs=gs;
	}

	@GetMapping("/user")
	@Operation(summary = "전체유저 랭킹", description = "condition DTO로 orderBy(pace, frequency, distance)구분")
	public ResponseEntity<?> totalUserRank(@RequestBody Condition con) {
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/user/my")
	@Operation(summary = "내 라이벌 보기 및 랭킹", description = "condition DTO로 orderBy(pace, frequency, distance)구분")
	public ResponseEntity<?> myUserRank(@RequestBody Condition con) {

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/group")
	@Operation(summary = "전체 그룹 랭킹", description = "condition DTO로 orderBy(pace, frequency, distance)구분")
	public ResponseEntity<?> totalGroupRank(@RequestBody Condition con) {

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/group/my")
	@Operation(summary = "내 그룹 보기 및 랭킹", description = "condition DTO로 orderBy(pace, frequency, distance)구분")
	public ResponseEntity<?> myGroupRank(@RequestBody Condition con) {

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/group/{groupId}")
	@Operation(summary = "그룹 내 멤버 랭킹", description = "groupid로 그룹 구분, condition DTO로 orderBy(pace, frequency, distance)구분")
	public ResponseEntity<?> GroupMemberank(@RequestBody Condition con) {

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
