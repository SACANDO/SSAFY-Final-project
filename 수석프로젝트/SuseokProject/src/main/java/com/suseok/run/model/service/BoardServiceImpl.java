package com.suseok.run.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.suseok.run.model.dto.Board;
import com.suseok.run.model.dto.Condition;

@Service
public class BoardServiceImpl implements BoardService {

	@Override
	public List<Board> searchBoard(Condition condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board readBoard(int boardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeBoard(int boardId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyBoard(Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean writeBoard(Board board) {
		// TODO Auto-generated method stub
		return false;
	}


}
