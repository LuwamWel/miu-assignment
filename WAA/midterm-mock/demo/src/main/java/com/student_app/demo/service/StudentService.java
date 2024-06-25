package com.student_app.demo.service;

import com.student_app.demo.entity.Course;
import com.student_app.demo.entity.Student;

import java.util.List;

public interface StudentService  {

    List<Student> findAllStudents();
    Student findStudentById(Long id);
    void deleteStudentById(Long id);
    Student saveStudent(Student student);
    Student update(Long id, Student student);
    List<Course> findCoursesByStudentId(Long id);
    List<Student> findStudentsByGpaLessThanOrEqual(Double gpa);
//    List<Student> findStudentsByProgramAndGpaLessThan(String program, Double gpa);

}
