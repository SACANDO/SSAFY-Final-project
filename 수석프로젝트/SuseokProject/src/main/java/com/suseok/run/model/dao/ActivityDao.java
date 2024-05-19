package com.suseok.run.model.dao;

import java.util.List;

import com.suseok.run.model.dto.StravaActivity;

public interface ActivityDao {
    void insertActivity(StravaActivity activity);
    List<StravaActivity> getAllActivities();
}