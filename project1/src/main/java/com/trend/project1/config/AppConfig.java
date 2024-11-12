package com.trend.project1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public void addCrosMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 모든 엔드포인트
                .allowedOrigins("http://localhost:3000")    // React 앱 주소 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE");    // 허용할 HTTP 메서드
    }
}
