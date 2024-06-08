package com.example.demo.repository;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    @Query("SELECT s.courses FROM Student s WHERE s.id=:id")
    List<Course> findCoursesByStudentId(@Param("id") Long id);

    @Query("SELECT s FROM Student s WHERE s.gpa<=:gpa")
    List<Student> findStudentsByGpaLessThanOrEqual(@Param("gpa") Double gpa);

//    @Query("SELECT s FROM Student s " +
//            "JOIN s.courses c " +
//            "JOIN c.coursedetails cd " +
//            "WHERE cd.program = :program AND s.gpa <= :gpa")
//    List<Student> findStudentByProgramAndGpaLessThanOrEqual(@Param("program") String program, @Param("gpa") Double gpa);

    @Query("SELECT s FROM Student s JOIN s.courses c WHERE c.coursedetails.program = 'MSC' AND s.gpa < :gpa")
    List<Student> findStudentsInMscProgramWithGpaLessThan(@Param("gpa") Double gpa);
}

