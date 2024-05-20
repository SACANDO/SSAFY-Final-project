package com.suseok.run.model.dao;

import com.suseok.run.model.dto.Record;
import com.suseok.run.model.dto.UserRankRecord;

import java.util.List;

public interface RecordDao {
    void insertRecord(Record record);

	List<Record> selectRecordsByUserId(String userId);

	List<Record> selectRecordsByUserSeq(int userSeq);

}
