package com.student_app.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Course {
    @Id
    @Column(name = "course_id")
    private Long id;
    private String name;

    @JsonBackReference
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;


    @JsonManagedReference
    @OneToOne(mappedBy = "course", cascade = CascadeType.REMOVE)
    private CourseDetails courseDetails;










//    private List<Student> students = new ArrayList<>();
//    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
//    private CourseDetails courseDetails;

}
