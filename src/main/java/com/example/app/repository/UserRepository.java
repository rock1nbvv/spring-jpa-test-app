package com.example.app.repository;

import com.example.app.entity.User;
import com.example.app.entity.request.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Vlad Baklaiev
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {
    Optional<UserDto> getViewById(Long id);
    List<UserDto> findUserBy();
    Optional<User> getEntityById(Long id);
}
