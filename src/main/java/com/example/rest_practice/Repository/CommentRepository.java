package com.example.rest_practice.Repository;

import com.example.rest_practice.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
