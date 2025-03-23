package com.example.rest_practice.Repository;

import com.example.rest_practice.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
