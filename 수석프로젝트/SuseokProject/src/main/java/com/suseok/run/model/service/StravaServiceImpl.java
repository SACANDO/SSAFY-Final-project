package com.suseok.run.model.service;

import com.suseok.run.model.dto.AccessToken;
import com.suseok.run.model.dto.StravaActivity;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class StravaServiceImpl implements StravaService {

    private final RestTemplate restTemplate;

    private final RecordService recordService;

    public StravaServiceImpl(RestTemplateBuilder restTemplateBuilder,RecordService recordService) {
        this.restTemplate = restTemplateBuilder.build();
        this.recordService = recordService;
    }

    @Override
    public StravaActivity[] getActivities(String accessToken) {
        String url = "https://www.strava.com/api/v3/athlete/activities";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<StravaActivity[]> response = restTemplate.exchange(
            url, HttpMethod.GET, entity, StravaActivity[].class);
        return response.getBody();
    }

    @Override
    public AccessToken refreshAccessToken(String clientId, String clientSecret, String refreshToken) {
        String url = "https://www.strava.com/api/v3/oauth/token";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("grant_type", "refresh_token");
        params.add("refresh_token", refreshToken);

        ResponseEntity<AccessToken> response = restTemplate.postForEntity(url, params, AccessToken.class);
        return response.getBody();
    }

    @Override
    public void saveStravaActivities(String accessToken, int userSeq) {
        StravaActivity[] activities = getActivities(accessToken);
        for (StravaActivity activity : activities) {
            recordService.saveRecord(activity, userSeq);
        }
    }
}
