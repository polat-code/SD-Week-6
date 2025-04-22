package org.softwaredev.sdweek6.user.domain.http.request;

import lombok.Builder;

@Builder
public record UserRequest(
    String name,
    String surname,
    String email,
    String password,
    String nickname,
    String avatarName) {}
