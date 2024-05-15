package com.suseok.run.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suseok.run.model.dao.BoardDao;
import com.suseok.run.model.dto.Board;
import com.suseok.run.model.dto.Reply;

@Service
public class BoardServiceImpl implements BoardService {


	@Autowired
	BoardDao bd;
	
	@Override
	public List<Board> search(String con) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board selectById(int boardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int boardId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteReply(int boardId, int replyId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertReply(Reply reply) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Board> selectAllByGroupId(int groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reply selectReplyById(int replyId) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
