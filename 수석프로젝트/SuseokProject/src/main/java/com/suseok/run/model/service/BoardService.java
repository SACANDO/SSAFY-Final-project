package com.suseok.run.model.service;

import java.util.List;

import com.suseok.run.model.dto.Board;
import com.suseok.run.model.dto.Condition;
import com.suseok.run.model.dto.Reply;


public interface BoardService {

	List<Board> search(Condition condition);

	Board selectById(int boardId);

	boolean delete(int boardId);

	boolean update(Board board);

	boolean insert(Board board);

	boolean deleteReply(int boardId, int replyId);

	boolean insertReply(Reply reply);

}
