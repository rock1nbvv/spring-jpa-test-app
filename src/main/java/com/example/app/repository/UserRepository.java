package com.example.app.repository;

import com.example.app.entity.User;
import com.example.app.entity.request.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Vlad Baklaiev
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<UserDto> getViewById(Long id);
}
