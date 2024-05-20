package com.suseok.run.controller;

import com.suseok.run.model.dto.AccessToken;
import com.suseok.run.model.service.StravaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/strava")
public class ActivityController {

    @Autowired
    private StravaService stravaService;

    // Strava 활동 데이터를 가져와 records 테이블에 저장
    @GetMapping("/fetch-activities")
    public void fetchStravaActivities(@RequestParam String accessToken, @RequestParam int userSeq) {
        stravaService.saveStravaActivities(accessToken, userSeq);
    }

    // 액세스 토큰 갱신
    @PostMapping("/refresh-token")
    public AccessToken refreshToken(@RequestParam String clientId, @RequestParam String clientSecret, @RequestParam String refreshToken) {
        return stravaService.refreshAccessToken(clientId, clientSecret, refreshToken);
    }
}
