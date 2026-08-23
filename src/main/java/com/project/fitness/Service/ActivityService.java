package com.project.fitness.Service;

import com.project.fitness.Repository.ActivityRepository;
import com.project.fitness.Repository.UserRepository;
import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public ActivityResponse trackActivity(ActivityRequest request){
        User user=userRepository.findById(request.getUserId())
                .orElseThrow(()->new RuntimeException("Invalid User"+request.getUserId()));
        Activity activity=Activity.builder().duration(request.getDuration())
                .user(user)
                .caloriesBurned(request.getCaloriesBurned()).type(request.getType())
                .additionalMetrics(request.getAdditionalMetrics()).startTime(request.getStartTime()).build();

   Activity savedActivity= activityRepository.save(activity);
   return mapToResponse(savedActivity);
    }

    private ActivityResponse mapToResponse(Activity savedActivity) {
    ActivityResponse activityResponse=new ActivityResponse();
    activityResponse.setAdditionalMetrics(savedActivity.getAdditionalMetrics());
    activityResponse.setCaloriesBurned(savedActivity.getCaloriesBurned());
    activityResponse.setCreatedAt(savedActivity.getCreatedAt());
    activityResponse.setDuration(savedActivity.getDuration());
    activityResponse.setId(savedActivity.getId());
    activityResponse.setStartTime(savedActivity.getStartTime());
    activityResponse.setType(savedActivity.getType());
    activityResponse.setUpdatedAt(savedActivity.getUpdatedAt());
    activityResponse.setUserId(savedActivity.getUser().getId());
    return activityResponse;
    }

    public List<ActivityResponse> getUserActivities(String userId) {
        List<Activity>activityList=activityRepository.findByUserId(userId);
//        1-Activity->ActivityResponse->collect in a list
        return activityList.stream().map(this::mapToResponse).collect(Collectors.toList());
    }
}
