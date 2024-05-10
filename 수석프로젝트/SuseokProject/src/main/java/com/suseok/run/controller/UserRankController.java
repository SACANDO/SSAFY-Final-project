package com.suseok.run.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suseok.run.model.dto.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rank/user")
@Tag(name="RankRestController", description = "랭킹R")
public class UserRankController {
	
	@GetMapping("/user")
	@Operation(summary = "유저랭킹")
	public ResponseEntity<?> userRank(@RequestBody User user) {
			
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

}
