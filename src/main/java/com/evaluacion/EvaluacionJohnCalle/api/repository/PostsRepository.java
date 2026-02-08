package com.evaluacion.EvaluacionJohnCalle.api.repository;

import com.evaluacion.EvaluacionJohnCalle.api.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    List<Posts> findByUserId(Long userId);
}