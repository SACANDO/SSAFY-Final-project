package com.suseok.run.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.run.model.dto.Condition;
import com.suseok.run.model.dto.Group;
import com.suseok.run.model.dto.User;
import com.suseok.run.model.service.BoardService;
import com.suseok.run.model.service.GroupService;
import com.suseok.run.model.service.UserService;
import com.suseok.run.model.dto.Board;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/group")
@Tag(name = "GroupRestController", description = "그룹CRUD")
public class GroupController {

	private final UserService us;
	private final GroupService gs;

	public GroupController(UserService us, GroupService gs) {
		this.gs = gs;
		this.us = us;
	}

	private int findUserSeq(String userId) {
		User user = us.selectById(userId);
		return user.getUserSeq();
	}

	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@PostMapping
	@Operation(summary = "그룹 생성")
	public ResponseEntity<Group> createGroup(@RequestBody Group group, @RequestHeader("userId") String userId) {
		
		group.setGroupAdmin(findUserSeq(userId));
		if (gs.insert(group))
			return new ResponseEntity<>(group, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/{groupId}")
	@Operation(summary = "그룹 가입")
	public ResponseEntity<String> joinGroup(@PathVariable("groupId") int groupId,
			@RequestHeader("userId") String userId) {
		gs.join(groupId, userId);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@DeleteMapping("/{groupId}")
	@Operation(summary = "그룹 탈퇴")
	public ResponseEntity<String> exitGroup(@PathVariable("groupId") int groupId,
			@RequestHeader("userId") String userId) {
		gs.exit(groupId, userId);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@PutMapping("/{groupId}")
	@Operation(summary = "그룹정보 수정")
	public ResponseEntity<?> updateGroup(@PathVariable("groupId") int groupId, @RequestBody Group group,
			@RequestHeader("userId") String userId) {
		// 관리자만 허용 //관리자만 보이는 버튼
		if (group.getGroupAdmin() != findUserSeq(userId))
			return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
		
		group.setGroupId(groupId);
		if (gs.update(group))
			return new ResponseEntity<>(SUCCESS, HttpStatus.ACCEPTED);
		else return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{groupId}/delete/{memberId}")
	@Operation(summary = "그룹 멤버 강퇴")
	public ResponseEntity<?> deleteGroupMember(@PathVariable("groupId") int groupId,
			@PathVariable("memberId") int memberId, @RequestHeader("userId") String userId) {
		// if 유저아이디 == groupid 의 leader이면 바꾸기
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
