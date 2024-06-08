package com.example.demo.repository;

import com.example.demo.model.Course;
import com.example.demo.model.CourseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDetailsRepo extends JpaRepository<CourseDetails,Long> {
}
