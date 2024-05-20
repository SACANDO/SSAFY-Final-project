package com.suseok.run.model.service;

import java.util.List;

import com.suseok.run.model.dto.StravaActivity;
import com.suseok.run.model.dto.Record;

public interface RecordService {
	void saveRecord(StravaActivity activity, int userSeq);

	List<Record> selectRecordsByUser(String userId);
	
}
