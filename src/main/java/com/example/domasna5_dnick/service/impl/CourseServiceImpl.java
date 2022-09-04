package com.example.domasna5_dnick.service.impl;

import com.example.domasna5_dnick.model.Course;
import com.example.domasna5_dnick.model.enumerations.CourseLevel;
import com.example.domasna5_dnick.model.exceptions.CourseIdNotFoundException;
import com.example.domasna5_dnick.repository.CourseRepository;
import com.example.domasna5_dnick.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> listCourses() {
        return this.courseRepository.findAll();
    }

    @Override
    public List<Course> listCourseByLevel(CourseLevel courseLevel) {
        return this.courseRepository.findAllByCourseLevel(courseLevel);
    }

    @Override
    public Optional<Course> findById(Long courseId) {
        return this.courseRepository.findById(courseId);
    }

    @Override
    public Course save(String name, String description, CourseLevel courseLevel,String imageUrl) {
        Course course = new Course(name,description,courseLevel,imageUrl);
        return this.courseRepository.save(course);
    }

    @Override
    public Course edit(Long courseId, String name, String description, CourseLevel courseLevel,String imageUrl) {
        Course course = this.courseRepository.findById(courseId).orElseThrow(()->new CourseIdNotFoundException(courseId));
        course.setName(name);
        course.setDescription(description);
        course.setCourseLevel(courseLevel);
        course.setImageUrl(imageUrl);
        return  this.courseRepository.save(course);
    }

    @Override
    public void deleteById(Long courseId) {
        this.courseRepository.deleteById(courseId);
    }
}
