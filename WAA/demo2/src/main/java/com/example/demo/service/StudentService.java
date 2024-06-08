package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(Long id);
    void deleteById(Long id);
    void save(Student student);
    Student update(Long id, Student student);
    List<Course> findCoursesByStudentId(Long id);
    List<Student> findStudentsByGpaLessThanOrEqual(Double gpa);

    List<Student> findStudentsInMscProgramWithGpaLessThan(Double gpa);
//    List<Student> findStudentByProgramAndGpaLessThan(String program, Double gpa);
   // List<Student> findStudentByProgramAndGpaLessThanOrEqual(String program, Double gpa);
}
