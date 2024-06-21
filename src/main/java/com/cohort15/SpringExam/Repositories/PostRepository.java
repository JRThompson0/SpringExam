package com.cohort15.SpringExam.Repositories;

import com.cohort15.SpringExam.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
