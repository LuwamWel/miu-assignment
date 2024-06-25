package com.student_app.demo.repo;

import com.student_app.demo.entity.Course;
import com.student_app.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
}
