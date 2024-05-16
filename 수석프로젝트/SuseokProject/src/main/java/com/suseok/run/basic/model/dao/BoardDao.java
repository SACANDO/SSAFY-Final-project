package com.suseok.run.basic.model.dao;

import java.util.List;

import com.suseok.run.basic.model.dto.Board;
import com.suseok.run.basic.model.dto.Reply;

public interface BoardDao {
	// CRUD : insert, selectAll, update, delete

	boolean insert(Board board);

	List<Board> selectAll();
	
	Board selectById(int boardId);

	boolean update(Board board);

	boolean delete(int boardId);

	List<Board> search(String con);

	boolean deleteReply(int boardId, int replyId);

	boolean insertReply(Reply reply);

	Reply selectReplyById(int replyId);
}
