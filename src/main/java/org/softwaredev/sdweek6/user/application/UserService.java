package org.softwaredev.sdweek6.user.application;

import lombok.RequiredArgsConstructor;
import org.softwaredev.sdweek6.user.domain.entity.User;
import org.softwaredev.sdweek6.user.domain.http.request.UserRequest;
import org.softwaredev.sdweek6.user.domain.http.response.UserResponse;
import org.softwaredev.sdweek6.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public ResponseEntity<UserResponse> createUser(UserRequest userRequest) {

    return new ResponseEntity<>(createUserAndReturnResponse(userRequest), HttpStatus.OK);
  }

  private UserResponse createUserAndReturnResponse(UserRequest userRequest) {
    User user =
        User.builder()
            .email(userRequest.email())
            .password(userRequest.password())
            .name(userRequest.name())
            .surname(userRequest.surname())
            .isActiveUser(true)
            .nickname(userRequest.nickname())
            .avatarName(userRequest.avatarName())
            .build();
    user = userRepository.save(user);
    return createUserResponse(user);
  }

  private static UserResponse createUserResponse(User user) {
    return UserResponse.builder()
        .id(user.getId())
        .name(user.getName())
        .nickname(user.getNickname())
        .avatarName(user.getAvatarName())
        .email(user.getEmail())
        .build();
  }

  public ResponseEntity<List<UserResponse>> createMultipleUser(List<UserRequest> userRequests) {
    List<UserResponse> userResponses =
        userRequests.stream().map(this::createUserAndReturnResponse).collect(Collectors.toList());
    return new ResponseEntity<>(userResponses, HttpStatus.OK);
  }

  public ResponseEntity<List<UserResponse>> filterUsers(String email, Boolean active) {
    List<User> users = new ArrayList<>();
    if (email != null && active != null) {
      users = userRepository.findByEmailContainingIgnoreCaseAndIsActiveUser(email, active);
    } else if (email != null) {
      users = userRepository.findByEmailContainingIgnoreCase(email);
    } else if (active != null) {
      users = userRepository.findByIsActiveUser(active);
    } else {
      users = userRepository.findAll();
    }

    return new ResponseEntity<>(convertUsersToUserResponses(users), HttpStatus.OK);
  }

  private List<UserResponse> convertUsersToUserResponses(List<User> users) {
    return users.stream().map(UserService::createUserResponse).collect(Collectors.toList());
  }
}
