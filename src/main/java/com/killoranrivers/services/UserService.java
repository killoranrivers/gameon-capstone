package com.killoranrivers.services;

import com.killoranrivers.models.User;
import com.killoranrivers.security.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);
    User save(UserRegistrationDto registration);
}