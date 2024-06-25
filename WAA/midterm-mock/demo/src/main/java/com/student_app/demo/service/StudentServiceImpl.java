package com.student_app.demo.service;

import com.student_app.demo.entity.Course;
import com.student_app.demo.entity.Student;
import com.student_app.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    public Student findStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        studentRepo.save(student);
        return student;
    }

    public Student update(Long id, Student student) {
        Student stud = studentRepo.findById(id).orElse(null);
        if (stud != null) {
            stud.setName(student.getName());
            return studentRepo.save(stud);
        }else{
            return null;
        }
    }

    public void deleteStudentById(Long id) {
        studentRepo.deleteById(id);
    }

    public List<Course> findCoursesByStudentId(Long id) {
        return studentRepo.findCoursesByStudentId(id);
    }

    @Override
    public List<Student> findStudentsByGpaLessThanOrEqual(Double gpa) {
        return studentRepo.findStudentsByGpaLessThanOrEqual(gpa);
    }

//    @Override
//    public List<Student> findStudentsByProgramAndGpaLessThan(String program, Double gpa) {
//        return studentRepo.findStudentsByProgramAndGpaLessThan(program, gpa);
//    }

}
