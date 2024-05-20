package com.suseok.run.model.service;

import com.suseok.run.model.dto.Record;
import com.suseok.run.model.dto.StravaActivity;
import com.suseok.run.model.dao.RecordDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    private RecordDao rd;
    @Autowired
    private RankService rs;

    public void saveRecord(StravaActivity activity, int userSeq) {
        Record record = new Record();
        record.setDistance(activity.getDistance());
        record.setRunTime(activity.getMovingTime() / 60.0); // run_time in minutes
        record.setPace((activity.getMovingTime() / 60.0) / (activity.getDistance() / 1000.0)); // pace in minutes per kilometer
        record.setUserSeq(userSeq);

        rd.insertRecord(record);
        rs.updateRankRecord(record, userSeq);
        
    }

	@Override
	public List<Record> selectRecordsByUser(String userId) {
		return rd.selectRecordsByUserId(userId);
	}
}
