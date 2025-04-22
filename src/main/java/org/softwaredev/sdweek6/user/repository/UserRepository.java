package org.softwaredev.sdweek6.user.repository;

import org.softwaredev.sdweek6.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
