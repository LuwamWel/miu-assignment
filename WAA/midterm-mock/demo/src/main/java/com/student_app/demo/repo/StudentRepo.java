package com.student_app.demo.repo;

import com.student_app.demo.entity.Course;
import com.student_app.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    @Query("SELECT s.courses FROM Student s WHERE s.id =:id")
    public List<Course> findCoursesByStudentId(Long id);

    @Query("SELECT s FROM Student s WHERE s.gpa=:gpa")
    List<Student> findStudentsByGpaLessThanOrEqual(@Param("gpa") Double gpa);

//    @Query("SELECT s FROM Student s " +
//            "JOIN s.courses c " +
//            "JOIN c.courseDetails cd " +
//            "WHERE cd.program=: MSC AND s.gpa<:gpa ")
//    List<Student> findStudentsByProgramAndGpaLessThan(String program, @Param("gpa")Double gpa);
}
