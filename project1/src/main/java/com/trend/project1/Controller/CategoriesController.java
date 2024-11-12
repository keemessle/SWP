package com.trend.project1.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoriesController {

    @GetMapping("/categories")
    public Map<String, String> getCategories(){
        Map<String, String> categories = new HashMap<>();
        categories.put("home", "Welcome");
        categories.put("phsical",  "Physical Wellness Tips");
        categories.put("mental", "Mental Wellness Tips");
        categories.put("spiritual", "Spiritual Wellness Tips");
        categories.put("social", "Social Wellness Tips");
        return categories;
    }
}
