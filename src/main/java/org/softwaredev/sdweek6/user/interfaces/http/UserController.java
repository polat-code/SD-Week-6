package org.softwaredev.sdweek6.user.interfaces.http;

import lombok.RequiredArgsConstructor;
import org.softwaredev.sdweek6.user.application.UserService;
import org.softwaredev.sdweek6.user.domain.http.request.UserRequest;
import org.softwaredev.sdweek6.user.domain.http.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

  private final UserService userService;

  @PostMapping("")
  public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
    return userService.createUser(userRequest);
  }

  @PostMapping("/multiple")
  public ResponseEntity<List<UserResponse>> createMultipleUser(
      @RequestBody List<UserRequest> userRequests) {
    return userService.createMultipleUser(userRequests);
  }
}
