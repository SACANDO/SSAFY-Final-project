package com.suseok.record.model.dao;

import com.suseok.record.model.dto.Record;

public interface UserRecordDao {

	int insert(Record record);

	int updateFreq(int userSeq);
	
	int updateDist(int userSeq);
	
	int updateSpeed(int userSeq);
	
	int deleteRecord(int userSeq);
}
