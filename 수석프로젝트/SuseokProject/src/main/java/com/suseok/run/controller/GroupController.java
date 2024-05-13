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
import com.suseok.run.model.dto.Group;
import com.suseok.run.model.service.BoardService;
import com.suseok.run.model.service.GroupService;
import com.suseok.run.model.dto.Board;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/group")
@Tag(name="GroupRestController", description = "그룹CRUD")
public class GroupController {
	
	private final GroupService gs;

	public GroupController(GroupService gs) {
		this.gs = gs;
	}
	
	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@PostMapping
	@Operation(summary="그룹 생성")
	public ResponseEntity<?> createGroup(@RequestBody Group group) {
		if(gs.insert(group)) 
			return new ResponseEntity<>(HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping ("/{groupId}")
	@Operation(summary="그룹 가입")
	public ResponseEntity<?> joinGroup(@PathVariable ("groupId") int groupId) {
		//group id와 login한 유저 정보를 넘기기
//		gs.join(groupId,userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{groupId}")
	@Operation(summary="그룹 탈퇴")
	public ResponseEntity<?> exitGroup(@PathVariable ("groupId") int groupId) {
		//group id와 login한 유저 정보로 delete
		// gs.exit(groupId,userId)
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{groupId}")
	@Operation(summary="그룹정보 수정")
	public ResponseEntity<?> updateGroup(@PathVariable ("groupId") int groupId, @RequestBody Group group) {
		//관리자만 허용	//관리자만 보이는 버튼
		
		group.setGroupId(groupId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@DeleteMapping("/{groupId}/delete/{memberId}")
	@Operation(summary="그룹 멤버 강퇴")
	public ResponseEntity<?> deleteGroupMember(@PathVariable ("groupId") int groupId, @PathVariable ("memberId") int memberId) {
		// if 유저아이디 == groupid 의 leader이면 바꾸기
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
