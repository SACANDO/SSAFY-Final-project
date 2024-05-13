package com.suseok.run.model.service;

import java.util.List;

import com.suseok.run.model.dto.Board;
import com.suseok.run.model.dto.Condition;

public interface BoardService {

	List<Board> searchBoard(Condition condition);

	Board readBoard(int boardId);

	boolean removeBoard(int boardId);

	boolean modifyBoard(Board board);

	boolean writeBoard(Board board);

}
