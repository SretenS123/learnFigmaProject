package com.example.domasna5_dnick.service;

import com.example.domasna5_dnick.model.Course;
import com.example.domasna5_dnick.model.enumerations.CourseLevel;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> listCourses();

    List<Course> listCourseByLevel(CourseLevel courseLevel);

    Optional<Course> findById(Long courseId);

    Course save(String name, String description, CourseLevel courseLevel,String imageUrl);

    Course edit(Long courseId,String name,String description,CourseLevel courseLevel,String imageUrl);

    void deleteById(Long courseId);


}
