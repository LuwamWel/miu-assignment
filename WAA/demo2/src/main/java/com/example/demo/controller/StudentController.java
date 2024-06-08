package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAllStudent() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        studentService.deleteById(id);
    }

    @PostMapping
    public void save(Student student) {
        studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable("id") Long id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @GetMapping("/{id}/courses")
    List<Course> findCoursesByStudentId(@PathVariable("id") Long id) {
        return studentService.findCoursesByStudentId(id);
    }

    @GetMapping("/gpa/{gpa}")
    List<Student> findStudentsByGpaLessThanOrEqual(@PathVariable("gpa") Double gpa) {
        return studentService.findStudentsByGpaLessThanOrEqual(gpa);
    }

//    @GetMapping("/program")
//    public List<Student> findStudentByProgramAndGpaLessThanOrEqual(@RequestParam String program, @RequestParam Double gpa) {
//        return studentService.findStudentByProgramAndGpaLessThanOrEqual(program, gpa);
//    }


    @GetMapping("/msc-program")
    public List<Student> findStudentsInMscProgramWithGpaLessThan(@RequestParam Double gpa) {
        return studentService.findStudentsInMscProgramWithGpaLessThan(gpa);
    }
}