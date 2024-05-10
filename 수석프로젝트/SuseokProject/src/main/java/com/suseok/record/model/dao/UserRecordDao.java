package com.suseok.record.model.dao;

import com.suseok.record.model.dto.Records;

public interface UserRecordDao {

	int insert(Records record);

	int updateFreq(int userSeq);
	
	int updateDist(int userSeq);
	
	int updateSpeed(int userSeq);
	
	int deleteRecord(int userSeq);
}
