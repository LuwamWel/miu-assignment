package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="description_id")
    private Long id;
    @Column(name="course_description")
    private String description;
    private int credit;
    private String program;
    private String last_update;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name="course_id")
    private Course course;
}
