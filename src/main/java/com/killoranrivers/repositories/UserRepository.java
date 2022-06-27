package com.killoranrivers.repositories;

import com.killoranrivers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Custom queries here
    User findByEmail(String email);

}