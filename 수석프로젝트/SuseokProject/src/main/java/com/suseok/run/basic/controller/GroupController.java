package com.suseok.run.basic.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.run.basic.model.dto.Board;
import com.suseok.run.basic.model.dto.Group;
import com.suseok.run.basic.model.dto.User;
import com.suseok.run.basic.model.service.BoardService;
import com.suseok.run.basic.model.service.GroupService;
import com.suseok.run.basic.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/group")
@Tag(name = "(완료)GroupRestController", description = "그룹CRUD")
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
	@Operation(summary = "createGroup")
	public ResponseEntity<Group> createGroup(@RequestBody Group group, @RequestHeader("userId") String userId) {

		group.setGroupAdmin(findUserSeq(userId));
		if (gs.insert(group))
			return new ResponseEntity<>(group, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/{groupId}")
	@Operation(summary = "joinGroup")
	public ResponseEntity<String> joinGroup(@PathVariable("groupId") int groupId,
			@RequestHeader("userId") String userId) {
		gs.join(groupId, userId);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@DeleteMapping("/{groupId}")
	@Operation(summary = "exitGroup")
	public ResponseEntity<String> exitGroup(@PathVariable("groupId") int groupId,
			@RequestHeader("userId") String userId) {
		gs.exit(groupId, userId);
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@PutMapping("/{groupId}")
	@Operation(summary = "updateGroupInfo")
	public ResponseEntity<Group> updateGroupInfo(@PathVariable("groupId") int groupId, @RequestBody Group group,
			@RequestHeader("userId") String userId) {
		// 관리자만 허용 //관리자만 보이는 버튼
		if (group.getGroupAdmin() != findUserSeq(userId))
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		group.setGroupId(groupId);
		if (gs.update(group))
			return new ResponseEntity<Group>(group, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{groupId}/delete/{memberId}")
	@Operation(summary = "deleteGroupMember")
	public ResponseEntity<?> deleteGroupMember(@PathVariable("groupId") int groupId, @RequestBody Group group,
			@PathVariable("memberId") int memberId, @RequestHeader("userId") String userId) {
		// if 유저아이디 == groupid 의 leader이면 바꾸기

		if (group.getGroupAdmin() != findUserSeq(userId))
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		if (gs.kickOut(groupId, memberId))
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/search")
	@Operation(summary = "searchGroup")
	public ResponseEntity<List<Group>> searchGroup(@RequestParam String con) {
		List<Group> groups = gs.search(con);
		if (groups != null)
			return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
