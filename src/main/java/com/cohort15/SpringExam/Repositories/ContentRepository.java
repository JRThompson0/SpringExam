package com.cohort15.SpringExam.Repositories;

import com.cohort15.SpringExam.Models.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long>
{

}
