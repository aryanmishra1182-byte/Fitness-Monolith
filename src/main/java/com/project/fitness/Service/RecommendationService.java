package com.project.fitness.Service;

import com.project.fitness.Repository.ActivityRepository;
import com.project.fitness.Repository.RecommendationRepository;
import com.project.fitness.Repository.UserRepository;
import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    public Recommendation generateRecommendation(RecommendationRequest request) {
        User user=userRepository.findById(request.getUserId()).orElseThrow(()->new RuntimeException("Invalid User: "+request.getUserId()));
        Activity activity=activityRepository.findById(request.getActivityId()).orElseThrow(()-> new RuntimeException("Invalid Activity: "+request.getActivityId()));
        Recommendation recommendation=Recommendation.builder()
                .suggestion(request.getSuggestion())
                .safety(request.getSafety())
                .improvements(request.getImprovements())
                .activity(activity)
                .user(user).build();
        return recommendationRepository.save(recommendation);
    }

    public List<Recommendation> getUserRecommendation(String userId) {
        return recommendationRepository.findByUserId(userId);
    }

    public List<Recommendation> getActivityRecommendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId);
    }
}