package com.student_app.demo.controller;

import com.student_app.demo.entity.Course;
import com.student_app.demo.entity.Student;
import com.student_app.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    @PostMapping("/")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

    @GetMapping("/{id}/courses")
    public List<Course> findCoursesByStudentId(@PathVariable Long id) {
        return studentService.findCoursesByStudentId(id);
    }

    @GetMapping("/gpa/{gpa}")
    public List<Student> findStudentsByGpaLessThanOrEqual(@PathVariable double gpa) {
        return studentService.findStudentsByGpaLessThanOrEqual(gpa);
    }

//    @GetMapping("/program")
//    public List<Student> findStudentsByProgramAndGpaLessThan(@RequestParam String program, Double gpa) {
//        return studentService.findStudentsByProgramAndGpaLessThan(program, gpa);
//    }
}

