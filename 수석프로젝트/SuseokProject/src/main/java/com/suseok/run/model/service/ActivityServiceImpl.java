package com.suseok.run.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suseok.run.model.dao.ActivityDao;
import com.suseok.run.model.dto.StravaActivity;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService{

	
    @Autowired
    private ActivityDao activityDao;

    @Override
    public void saveActivities(StravaActivity[] activities) {
        for (StravaActivity activity : activities) {
            activityDao.insertActivity(activity);
        }
    }

    @Override
    public List<StravaActivity> getAllActivities() {
        return activityDao.getAllActivities();
    }
}