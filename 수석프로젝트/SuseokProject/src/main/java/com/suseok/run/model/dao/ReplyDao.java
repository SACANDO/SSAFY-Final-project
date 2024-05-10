package com.suseok.run.model.dao;

import java.util.List;

import com.suseok.run.model.dto.Reply;


public interface ReplyDao {
	// CRUD : insert, selectAll, update, delete

	int insert(Reply reply);

	List<Reply> selectAll();
	
	Reply selectById(int replyId);

	int update(Reply reply);

	int delete(int replyId);
}
