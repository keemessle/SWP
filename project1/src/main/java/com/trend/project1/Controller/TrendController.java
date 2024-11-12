package com.trend.project1.Controller;

import com.trend.project1.Service.NaverTrendService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TrendController {

    private final NaverTrendService naverTrendService;
//    private final GoogleTrendService googleTrendService;

    public TrendController(NaverTrendService naverTrendService) {
        this.naverTrendService = naverTrendService;
//        this.googleTrendService = googleTrendService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/trend")
    public String getTrendData(@RequestParam(name = "keyword") String keyword) {
        try {
            String naverData = naverTrendService.getNaverTrend(keyword);
//            String googleData = googleTrendService.getGoogleTrend(keyword);
            return naverData;
            // 두 데이터 조합 naverData + googleData;
        } catch (Exception e) {
            e.printStackTrace();
            return "서버 오류";
        }
    }


}
