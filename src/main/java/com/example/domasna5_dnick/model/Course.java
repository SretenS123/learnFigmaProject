package com.example.domasna5_dnick.model;

import com.example.domasna5_dnick.model.enumerations.CourseLevel;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String name;

    private String description;
    @Enumerated(EnumType.STRING)
    private CourseLevel courseLevel;

    public Course(){}

    public Course(String name, String description,CourseLevel courseLevel,String imageUrl) {
        this.name = name;
        this.description = description;
        this.courseLevel = courseLevel;
        this.imageUrl = imageUrl;
    }
}
