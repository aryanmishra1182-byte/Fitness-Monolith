package com.project.fitness.Controller;

import com.project.fitness.Repository.RecommendationRepository;
import com.project.fitness.Service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {
    private final RecommendationService recommendationService;
    @PostMapping("/generate")
    public ResponseEntity<RecommendationResponse>

}
