package com.suseok.record.model.dao;

import java.util.List;

import com.suseok.record.model.dto.Records;

public interface RecordsDao {

	// 기록 등록(insert) 
	int insert(Records record);
	
	// 전체 기록 선택
	List<Records> selectAll();
	
	// 기록 갱신(update)
	int update(Records record);
	
	// 기록 삭제(delete)
	int delete(int id);
}
