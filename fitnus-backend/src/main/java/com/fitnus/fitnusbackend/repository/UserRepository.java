package com.fitnus.fitnusbackend.repository;

import com.fitnus.fitnusbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Long> {
    User findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}
