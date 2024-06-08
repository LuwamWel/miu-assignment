package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        Student student1 = findById(id);
        if (student1.getName() != null) {
            student1.setName(student.getName());
        }
        if (student1.getGpa() != null) {
            student1.setGpa(student.getGpa());
        }

        return studentRepo.save(student1);
    }

    @Override
    public List<Course> findCoursesByStudentId(Long id) {
        return studentRepo.findCoursesByStudentId(id);
    }

    @Override
    public List<Student> findStudentsByGpaLessThanOrEqual(Double gpa) {
        return studentRepo.findStudentsByGpaLessThanOrEqual(gpa);
    }

//    @Override
//    public List<Student> findStudentByProgramAndGpaLessThanOrEqual(String program, Double gpa) {
//        return studentRepo.findStudentByProgramAndGpaLessThanOrEqual(program, gpa);
//    }


    public List<Student> findStudentsInMscProgramWithGpaLessThan(Double gpa) {
        return studentRepo.findStudentsInMscProgramWithGpaLessThan(gpa);
    }
}