package com.suseok.run.model.service;

import java.util.List;

import com.suseok.run.model.dto.StravaActivity;

public interface ActivityService {

	void saveActivities(StravaActivity[] activities);

    List<StravaActivity> getAllActivities();
	
}
