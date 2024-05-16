package com.suseok.run.core.model.service;

import java.util.List;

import com.suseok.run.core.model.dto.Records;
import com.suseok.run.core.model.dto.UserBadges;

public interface RecordsService {

	boolean insert(Record record);

	List<Records> selectAllByUser(String userId);
	
	List<UserBadges> selectBadgesByUser(String userId);

}
