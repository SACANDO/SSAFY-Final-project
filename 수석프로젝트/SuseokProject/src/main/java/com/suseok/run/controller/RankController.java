package com.suseok.run.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.run.jwtutill.AuthRequired;
import com.suseok.run.model.dto.Group;
import com.suseok.run.model.dto.UserRankRecord;
import com.suseok.run.model.service.RankService;
import com.suseok.run.model.service.RecordService;
import com.suseok.run.model.dto.Record;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping
@Tag(name = "RankRecordRestController", description = "랭킹R")
public class RankController {

	private final RankService rs;
	private final RecordService res;

	public RankController(RankService rs, RecordService res) {
		this.rs = rs;
		this.res=res;
	}


//	@AuthRequired
	@GetMapping("/myLog")
	@Operation(summary = "myLog", description = "내 전체 기록")
	public ResponseEntity<List<Record>> myLog(@RequestHeader("userId") String userId) {

		List<Record> records = res.selectRecordsByUser(userId);

		if (records == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		return new ResponseEntity<List<Record>>(records, HttpStatus.OK);
	}

//	@AuthRequired
	@GetMapping("/myRR")
	@Operation(summary = "myRR", description = "(기본) 뱃지클릭, 스트릭클릭, 프사클릭 등등")
	public ResponseEntity<UserRankRecord> myRR(@RequestHeader("userId") String userId) {

		UserRankRecord userRankRecord = rs.selectByUser(userId);

		if (userRankRecord == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		return new ResponseEntity<UserRankRecord>(userRankRecord, HttpStatus.OK);
	}

	@GetMapping("/rank/user")
	@Operation(summary = "totalUserRank", description = "condition 으로 orderBy(pace, frequency, distance)구분")
	public ResponseEntity<List<UserRankRecord>> totalUserRank(@RequestParam String con) {
		// 전체 유저 랭킹 : 유저 레코드에서 뽑아오기
		List<UserRankRecord> userRecords = rs.selectAllOrderBy(con);

		if (userRecords != null)
			return new ResponseEntity<List<UserRankRecord>>(userRecords, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

//	@AuthRequired
	@GetMapping("/rank/user/my")
	@Operation(summary = "myRivalRank", description = "condition 으로 orderBy(pace, frequency, distance)구분")
	public ResponseEntity<?> myRivalRank(@RequestParam String con, @RequestHeader("userId") String userId) {
		// 라이벌 테이블에서 라이벌만 뽑아와서 걔들의 record를 나열해야 함
		List<UserRankRecord> userRecords = rs.selectAllRivalOrderBy(con, userId);

		if (userRecords != null)
			return new ResponseEntity<List<UserRankRecord>>(userRecords, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@AuthRequired
	@GetMapping("/rank/user/{rivalId}")
	@Operation(summary = "compareRank", description = "")
	public ResponseEntity<UserRankRecord> compareRank(@PathVariable("rivalId") String rivalId,
			@RequestHeader("userId") String userId) {

		UserRankRecord userRankRecord = rs.selectRival(userId, rivalId);

		if (userRankRecord != null)
			return new ResponseEntity<UserRankRecord>(userRankRecord, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@GetMapping("/rank/group")
	@Operation(summary = "totalGroupRank", description = "condition 으로 orderBy(pace, frequency, distance)구분")
	public ResponseEntity<?> totalGroupRank(@RequestParam String con) {

		List<Group> groups = rs.selectGroupsOrderBy(con);

		if (groups != null)
			return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

//	@AuthRequired
	@GetMapping("/rank/group/my")
	@Operation(summary = "myGroupRank", description = "condition 으로 orderBy(pace, frequency, distance)구분")
	public ResponseEntity<?> myGroupRank(@RequestParam String con, @RequestHeader("userId") String userId) {

		List<Group> groups = rs.selectMyGroupsOrderBy(con, userId);

		if (groups != null)
			return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

//	@AuthRequired
	@GetMapping("/rank/group/{groupId}")
	@Operation(summary = "GroupMemberank", description = "groupid로 그룹 구분, condition 으로 orderBy(pace, frequency, distance)구분")
	public ResponseEntity<?> GroupMemberank(@RequestParam String con, @PathVariable("groupId") int groupId) {

		List<UserRankRecord> userRecords = rs.selectAllMemberOrderBy(con, groupId);

		if (userRecords != null)
			return new ResponseEntity<List<UserRankRecord>>(userRecords, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
