package com.suseok.record.model.dao;

import java.util.List;

import com.suseok.record.model.dto.Record;

public interface RecordDao {

	// 기록 등록(insert) 
	int insert(Record record);
	
	// 전체 기록 선택
	List<Record> selectAll();
	
	// 기록 갱신(update)
	int update(Record record);
	
	// 기록 삭제(delete)
	int delete(int id);
}
