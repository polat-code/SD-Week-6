package org.softwaredev.sdweek6.user.repository;

import org.softwaredev.sdweek6.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmailContainingIgnoreCaseAndIsActiveUser(String email, Boolean isActiveUser);

    List<User> findByEmailContainingIgnoreCase(String email);

    List<User> findByIsActiveUser(Boolean isActiveUser);
}
