package com.example.app.repositories;

import com.example.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vlad Baklaiev
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
