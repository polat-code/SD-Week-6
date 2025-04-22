package org.softwaredev.sdweek6.user.domain.http.response;

import lombok.Builder;

@Builder
public record UserResponse(Long id, String name, String nickname, String avatarName) {}
