package com.suseok.run.basic.model.dao;

import java.util.List;

import com.suseok.run.basic.model.dto.Board;

public interface BoardDao {
	// CRUD : insert, selectAll, update, delete

	int insert(Board board);

	List<Board> selectAll();
	
	Board selectById(int boardId);

	int update(Board board);

	int delete(int boardId);
}
