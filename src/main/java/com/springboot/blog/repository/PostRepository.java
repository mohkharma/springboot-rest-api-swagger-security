package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import com.springboot.blog.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findByDescriptionAndTitle(String description, String title);
}
