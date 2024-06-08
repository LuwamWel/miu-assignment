package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @Column(name="course_id")
    private Long id;
    private String name;

    @JsonBackReference
    @ManyToMany(mappedBy="courses")
    private List<Student> students;


    @JsonManagedReference
    @OneToOne(mappedBy="course",cascade=CascadeType.REMOVE)
    private CourseDetails coursedetails;
}
