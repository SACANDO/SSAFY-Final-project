package com.suseok.run.model.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suseok.run.model.dao.BoardDao;
import com.suseok.run.model.dao.UserDao;
import com.suseok.run.model.dto.Board;
import com.suseok.run.model.dto.Reply;

@Service
public class BoardServiceImpl implements BoardService {


	@Autowired
	BoardDao bd;
	
	@Autowired
	UserDao ud;
	
	@Override
	public List<Board> selectAllByGroupId(int groupId) {
		return bd.selectAll();
	}

	@Override
	public Board selectById(int boardId) {
		return bd.selectById(boardId);
	}
	
	@Override
	public List<Board> search(String con) {
		return bd.search(con);
	}


	@Override
	public boolean delete(int boardId) {
		return bd.delete(boardId);
	}

	@Override
	public boolean update(Board board) {
		return bd.update(board);
	}

	@Override
	public Board insert(Board board) {
		bd.insert(board);
		return board;
	}

	@Override
	public boolean deleteReply(int boardId, int replyId) {
		return bd.deleteReply(boardId,replyId);
	}

	@Override
	public boolean insertReply(Reply reply) {
		return bd.insertReply(reply);
	}

	@Override
	public Reply selectReplyById(int replyId) {
		return bd.selectReplyById(replyId);
	}

	


}
