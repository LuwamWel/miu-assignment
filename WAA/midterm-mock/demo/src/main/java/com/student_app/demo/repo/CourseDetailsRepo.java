package com.student_app.demo.repo;

import com.student_app.demo.entity.CourseDetails;
import com.student_app.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDetailsRepo extends JpaRepository<CourseDetails, Long> {
}
