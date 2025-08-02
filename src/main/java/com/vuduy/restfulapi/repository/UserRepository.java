package com.vuduy.restfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vuduy.restfulapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
