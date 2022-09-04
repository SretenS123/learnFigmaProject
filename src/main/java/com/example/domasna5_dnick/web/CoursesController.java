package com.example.domasna5_dnick.web;

import com.example.domasna5_dnick.model.Course;
import com.example.domasna5_dnick.model.enumerations.CourseLevel;
import com.example.domasna5_dnick.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/courses")
public class CoursesController {

    private final CourseService courseService;

    public CoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    public String getCoursesPage( Model model)
    {

        return "courses_lvl";
    }
    @GetMapping("/{level}")
    public String getCoursesLvl(@PathVariable(required = false)String level,Model model){
        List<Course> courses  = null;
        if(level!=null && !level.isEmpty())
        {
            if(level.toString().equals("beginner"))
            {
                courses = this.courseService.listCourseByLevel(CourseLevel.BEGINNER);
                model.addAttribute("courses",courses);
                model.addAttribute("level",level.toUpperCase());
                return "courses";
            }
            if(level.toString().equals("intermediate"))
            {
                courses = this.courseService.listCourseByLevel(CourseLevel.INTERMEDIATE);
                model.addAttribute("courses",courses);
                model.addAttribute("level",level.toUpperCase());
                return "courses";
            }
            if(level.toString().equals("expert"))
            {
                courses = this.courseService.listCourseByLevel(CourseLevel.EXPERT);
                model.addAttribute("courses",courses);
                model.addAttribute("level",level.toUpperCase());
                return "courses";
            }

        }
        model.addAttribute("courses",courseService.listCourses());
        return "courses";
    }

}
