package com.example.domasna5_dnick.repository;

import com.example.domasna5_dnick.model.Course;
import com.example.domasna5_dnick.model.enumerations.CourseLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findAllByCourseLevel(CourseLevel courseLevel);
}
