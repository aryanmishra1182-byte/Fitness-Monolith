package com.project.fitness.Controller;

import com.project.fitness.Service.RecommendationService;
import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Recommendation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {
    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(@RequestBody RecommendationRequest request) {
        Recommendation recommendation = recommendationService.generateRecommendation(request);
        return ResponseEntity.ok(recommendation);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>> getUserRecommendation(@PathVariable String userId){
        return ResponseEntity.ok(recommendationService.getUserRecommendation(userId));
    }
    @GetMapping("/activity/{ActivityId}")
    public ResponseEntity<List<Recommendation>> getActivityRecommendation(@PathVariable String ActivityId){
        return ResponseEntity.ok(recommendationService.getActivityRecommendation(ActivityId));
    }
}
