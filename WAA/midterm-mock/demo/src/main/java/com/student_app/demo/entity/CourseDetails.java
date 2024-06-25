package com.student_app.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CourseDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="description_id")
    private Long id;
    @Column(name="course_description")
    private String description;
    private int credit;
    private String program;
    //@Column(name="last_updated")
    private String last_updated;

    @OneToOne
    @JoinColumn(name = "course_id")
    @JsonBackReference
    private Course course;



}
