package com.cohort15.SpringExam.Repositories;

import com.cohort15.SpringExam.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>
{
    List<User> findByUsername(String username);
}
