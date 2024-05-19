package com.suseok.run.model.service;

import com.suseok.run.model.dto.AccessToken;
import com.suseok.run.model.dto.StravaActivity;

public interface StravaService {

    StravaActivity[] getActivities(String accessToken);

    AccessToken refreshAccessToken(String clientId, String clientSecret, String refreshToken);
}