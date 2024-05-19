package com.suseok.run.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.suseok.run.model.dto.AccessToken;
import com.suseok.run.model.dto.StravaActivity;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class StravaServiceImpl {

    private final RestTemplate restTemplate;

    public StravaServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public StravaActivity[] getActivities(String accessToken) {
        String url = "https://www.strava.com/api/v3/athlete/activities";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<StravaActivity[]> response = restTemplate.exchange(
            url, HttpMethod.GET, entity, StravaActivity[].class);
        return response.getBody();
    }

    public AccessToken refreshAccessToken(String clientId, String clientSecret, String refreshToken) {
        String url = "https://www.strava.com/api/v3/oauth/token";
        Map<String, String> params = new HashMap<>();
        params.put("client_id", clientId);
        params.put("client_secret", clientSecret);
        params.put("grant_type", "refresh_token");
        params.put("refresh_token", refreshToken);

        ResponseEntity<AccessToken> response = restTemplate.postForEntity(url, params, AccessToken.class);
        return response.getBody();
    }
}
