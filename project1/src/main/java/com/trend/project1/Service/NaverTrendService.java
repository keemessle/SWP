package com.trend.project1.Service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NaverTrendService {

    private final RestTemplate restTemplate;

    private final String clientId = "7HmT6pDv44qg7u1dtcRP";
    private final String clientSecret = "4vGRA35bsf";

    public NaverTrendService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getNaverTrend(String keyword) {
        String apiUrl = "https://openapi.naver.com/v1/datalab/search";

        // 1. 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);

        // 2. 요청 본문 설정
        JSONObject requestBody = new JSONObject();
        requestBody.put("startDate", "2024-01-01"); // 시작 날짜
        requestBody.put("endDate", "2024-11-07");  // 종료 날짜
        requestBody.put("timeUnit", "month");   // 시간 단위 설정

        // keywordGroups 배열에 JSON 객체로 추가
        JSONArray keywordGroups = new JSONArray();
        JSONObject keywordObj = new JSONObject();
        keywordObj.put("groupName", "Keyword Group");   // 그룹 이름 설정
        keywordObj.put("keywords", new JSONArray().put(keyword)); // keywords 배열 생성
        keywordGroups.put(keywordObj);

        requestBody.put("keywordGroups", keywordGroups);    // keywordGroups를 최종 본문에 추가

        // HttpEntity를 통해 헤더와 본문을 결합
        HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);

        // 3. API 요청 보내기
        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                entity,
                String.class
        );

        // 응답 데이터 반환
        return response.getBody();


    }
}
