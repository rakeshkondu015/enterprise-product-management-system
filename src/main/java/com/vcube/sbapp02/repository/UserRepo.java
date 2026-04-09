package com.vcube.sbapp02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vcube.sbapp02.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}