package com.fitnus.fitnusbackend.repository;

import com.fitnus.fitnusbackend.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostModel,Long> {
}
