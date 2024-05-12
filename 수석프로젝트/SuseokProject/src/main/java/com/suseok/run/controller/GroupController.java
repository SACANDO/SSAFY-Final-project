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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/group/{groupId}")
@Tag(name="GroupRestController", description = "그룹CRUD")
public class GroupController {

	
	
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
	
	@GetMapping("/board")
	@Operation(summary="그룹 게시판")
	public ResponseEntity<?> groupBoard(@PathVariable ("groupId") int groupId) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/{boardId}")
	@Operation(summary="게시글상세")
	public ResponseEntity<?> Board(@PathVariable ("boardId") int boardId) {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/{boardId}")
	@Operation(summary="게시글작성")
	public ResponseEntity<?> createBoard(@PathVariable ("boardId") int boardId) {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/{boardId}")
	@Operation(summary="게시글수정")
	public ResponseEntity<?> updateBoard(@PathVariable ("boardId") int boardId) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	@DeleteMapping("/{boardId}")
	@Operation(summary="게시글삭제")
	public ResponseEntity<?> deleteBoard(@PathVariable ("boardId") int boardId) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/{boardId}/reply")
	@Operation(summary="댓글작성")
	public ResponseEntity<?> createReply(@PathVariable ("boardId") int boardId) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{boardId}/reply")
	@Operation(summary="댓글삭제")
	public ResponseEntity<?> deleteReply(@PathVariable ("boardId") int boardId) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
