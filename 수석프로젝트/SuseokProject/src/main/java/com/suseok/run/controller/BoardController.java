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
import com.suseok.run.model.dto.Reply;
import com.suseok.run.model.service.BoardService;
import com.suseok.run.model.dto.Board;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/group/{groupId}/board")
@Tag(name = "BoardRestController", description = "보드CRUD")
public class BoardController {

	private final BoardService bs;

	public BoardController(BoardService bs) {
		this.bs = bs;
	}

	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@GetMapping
	@Operation(summary = "그룹 게시판")
	public ResponseEntity<?> groupBoard(@PathVariable("groupId") int groupId) {

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{boardId}")
	@Operation(summary = "게시글상세")
	public ResponseEntity<?> Board(@PathVariable("boardId") int boardId) {
		Board board = bs.selectById(boardId);
		if (board != null)
			return new ResponseEntity<Board>(board, HttpStatus.OK);
		return new ResponseEntity<Board>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	@Operation(summary = "게시글작성")
	public ResponseEntity<?> createBoard(@RequestBody Board board) {
		bs.insert(board);
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}

	@PutMapping
	@Operation(summary = "게시글수정")
	public ResponseEntity<?> updateBoard(@RequestBody Board board) {
		if (bs.update(board))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{boardId}")
	@Operation(summary = "게시글삭제")
	public ResponseEntity<?> deleteBoard(@PathVariable("boardId") int boardId) {
		if (bs.delete(boardId))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/search")
	@Operation(summary = "게시글 검색")
	public ResponseEntity<?> list(@ModelAttribute Condition condition) {
		List<Board> list = bs.search(condition); // 검색 조회
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}

	@PostMapping("/{boardId}/reply")
	@Operation(summary = "댓글작성")
	public ResponseEntity<?> createReply(@RequestBody Reply reply) {
		if (bs.insertReply(reply))
			return new ResponseEntity<>(HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{boardId}/reply/{replyId}")
	@Operation(summary = "댓글삭제")
	public ResponseEntity<?> deleteReply(@PathVariable("boardId") int boardId, @PathVariable("replyId") int replyId) {
		if (bs.deleteReply(boardId, replyId))
			return new ResponseEntity<>(HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
