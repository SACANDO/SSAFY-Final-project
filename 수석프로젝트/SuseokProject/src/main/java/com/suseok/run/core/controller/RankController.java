package com.suseok.run.core.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.run.basic.jwtutill.AuthRequired;
import com.suseok.run.basic.model.dto.Group;
import com.suseok.run.basic.model.dto.User;
import com.suseok.run.basic.model.service.GroupService;
import com.suseok.run.basic.model.service.UserService;
import com.suseok.run.core.model.dto.UserRankRecord;
import com.suseok.run.core.model.service.RankService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rank")
@Tag(name = "RankRestController", description = "랭킹R")
public class RankController {

	private final UserService us;
	private final GroupService gs;
	private final RankService rs;

	public RankController(UserService us, GroupService gs, RankService rs) {
		this.us = us;
		this.gs = gs;
		this.rs = rs;
	}

	@GetMapping("/user")
	@Operation(summary = "totalUserRank", description = "condition 으로 orderBy(pace, frequency, distance)구분")
	public ResponseEntity<List<UserRankRecord>> totalUserRank(@RequestParam String con) {
		// 전체 유저 랭킹 : 유저 레코드에서 뽑아오기
		List<UserRankRecord> userRecords = rs.selectAllOrderBy(con);

		if (userRecords != null)
			return new ResponseEntity<List<UserRankRecord>>(userRecords, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@AuthRequired 
	@GetMapping("/user/my")
	@Operation(summary = "myUserRank", description = "condition 으로 orderBy(pace, frequency, distance)구분")
	public ResponseEntity<?> myUserRank(@RequestParam String con, @RequestHeader("userId") String userId) {
		// 라이벌 테이블에서 라이벌만 뽑아와서 걔들의 record를 나열해야 함
		List<UserRankRecord> userRecords = rs.selectAllRivalOrderBy(con, userId);

		if (userRecords != null)
			return new ResponseEntity<List<UserRankRecord>>(userRecords, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@AuthRequired 
	@GetMapping("/user/{rivalId}")
	@Operation(summary = "compareRank", description = "")
	public ResponseEntity<UserRankRecord> compareRank(@PathVariable("rivalId") String rivalId,
			@RequestHeader("userId") String userId) {
		
		UserRankRecord userRankRecord = rs.selectRival(userId,rivalId);

		if (userRankRecord != null)
			return new ResponseEntity<UserRankRecord>(userRankRecord, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@GetMapping("/group")
	@Operation(summary = "totalGroupRank", description = "condition 으로 orderBy(pace, frequency, distance)구분")
	public ResponseEntity<?> totalGroupRank(@RequestParam String con) {

		List<Group> groups = rs.selectGroupsOrderBy(con);

		if (groups != null)
			return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@AuthRequired 
	@GetMapping("/group/my")
	@Operation(summary = "myGroupRank", description = "condition 으로 orderBy(pace, frequency, distance)구분")
	public ResponseEntity<?> myGroupRank(@RequestParam String con, @RequestHeader("userId") String userId) {

		List<Group> groups = rs.selectMyGroupsOrderBy(con,userId);

		if (groups != null)
			return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@AuthRequired 
	@GetMapping("/group/{groupId}")
	@Operation(summary = "GroupMemberank", description = "groupid로 그룹 구분, condition 으로 orderBy(pace, frequency, distance)구분")
	public ResponseEntity<?> GroupMemberank(@RequestParam String con, @PathVariable("groupId") int groupId) {

		List<UserRankRecord> userRecords = rs.selectAllMemberOrderBy(con, groupId);

		if (userRecords != null)
			return new ResponseEntity<List<UserRankRecord>>(userRecords, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
