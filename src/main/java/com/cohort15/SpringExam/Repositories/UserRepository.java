package com.cohort15.SpringExam.Repositories;

import com.cohort15.SpringExam.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{

}
