package com.suseok.record.service;

import java.util.List;

import com.suseok.record.model.dto.Records;
import com.suseok.record.model.dto.UserBadges;

public interface RecordsService {

	boolean insert(Record record);

	List<Records> selectAllByUser(String userId);
	
	List<UserBadges> selectBadgesByUser(String userId);

}
