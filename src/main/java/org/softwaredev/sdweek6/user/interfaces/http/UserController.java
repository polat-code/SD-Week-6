package org.softwaredev.sdweek6.user.interfaces.http;

import lombok.RequiredArgsConstructor;
import org.softwaredev.sdweek6.user.application.UserService;
import org.softwaredev.sdweek6.user.domain.http.request.UserRequest;
import org.softwaredev.sdweek6.user.domain.http.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  // Built-in Query Usage
  @PostMapping("/multiple")
  public ResponseEntity<List<UserResponse>> createMultipleUser(
      @RequestBody List<UserRequest> userRequests) {
    return userService.createMultipleUser(userRequests);
  }

  // JPA Query Usage
  @GetMapping("/filter")
  public ResponseEntity<List<UserResponse>> filterUsers(
      @RequestParam(value = "email", required = false) String email,
      @RequestParam(value = "active", required = false) Boolean active) {
    return userService.filterUsers(email, active);
  }


}
