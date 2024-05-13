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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.run.model.dto.Condition;
import com.suseok.run.model.service.BoardService;
import com.suseok.run.model.service.GroupService;
import com.suseok.run.model.dto.Board;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/group/{groupId}")
@Tag(name="GroupRestController", description = "그룹CRUD")
public class GroupController {
	
	private final GroupService gs;

	public GroupController(GroupService gs) {
		this.gs = gs;
	}
	
	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	
	@GetMapping
	@Operation(summary="그룹 가입")
	public ResponseEntity<?> addGroup(@PathVariable ("groupId") int groupId) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping
	@Operation(summary="그룹 탈퇴")
	public ResponseEntity<?> exitGroup(@PathVariable ("groupId") int groupId) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping
	@Operation(summary="그룹정보 수정")
	public ResponseEntity<?> updateGroup(@PathVariable ("groupId") int groupId) {
		//관리자만 허용	//관리자만 보이는 버튼
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@DeleteMapping("/{memberId}")
	@Operation(summary="그룹 멤버 강퇴")
	public ResponseEntity<?> deleteGroupMember(@PathVariable ("groupId") int groupId, @PathVariable ("memberId") int memberId) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
