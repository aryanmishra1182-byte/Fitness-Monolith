package com.project.fitness.Service;

import com.project.fitness.Repository.UserRepository;
import com.project.fitness.dto.LoginRequest;
import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.model.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;
    public UserResponse register(RegisterRequest request) {
        UserRole role=request.getRole()!=null?request.getRole(): UserRole.USER;
        User user=User.builder().email(request.getEmail()).firstname(request.getFirstname()).lastname(request.getLastname()).role(role).password(passwordEncoder.encode(request.getPassword())).build();
//        User user = new User(
//                null, request.getEmail(), request.getPassword(), request.getFirstname(), request.getLastname(),
//                Instant.parse("2025-12-03T10:15:30.208Z")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime(),
//                Instant.parse("2007-12-03T10:15:30.208Z").atZone(ZoneOffset.UTC).toLocalDateTime(),
//                List.of(), List.of()
//        );
        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);
    }

    public UserResponse mapToResponse(User savedUser) {
        UserResponse response = new UserResponse();

        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setFirstname(savedUser.getFirstname());
        response.setLastname(savedUser.getLastname());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());

        return response;
    }

    public User authenticate(LoginRequest loginRequest) {
        User user=userRepository.findByEmail(loginRequest.getEmail());
        if(user==null) throw new RuntimeException("Invalid Credentials");
        if(!passwordEncoder.matches(loginRequest.getPassword(),user.getPassword()))
            throw new RuntimeException("Invalid Credentials");
//        String token=jwtUtils.generateToken(user.getId(),user.getRole().name());
//        return ResponseEntity.ok(new LoginResponse(token,userService.mapToResponse(user)));
        return user;

    }
}