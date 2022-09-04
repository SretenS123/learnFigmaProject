package com.example.domasna5_dnick.config;

import com.example.domasna5_dnick.model.Course;
import com.example.domasna5_dnick.model.User;
import com.example.domasna5_dnick.model.enumerations.CourseLevel;
import com.example.domasna5_dnick.service.CourseService;
import com.example.domasna5_dnick.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitilizer {

    private final CourseService courseService;
    private final UserService userService;

    public DataInitilizer(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }

    @PostConstruct
    public void initData(){

        Course course1 = this.courseService.save("Figma masteries","Creating Table", CourseLevel.BEGINNER,"https://i.ytimg.com/vi/g6rQFP9zCAM/maxresdefault.jpg");
        Course course2 = this.courseService.save("Figma icons","Creating Icons", CourseLevel.BEGINNER,"https://cdn.cssauthor.com/wp-content/uploads/2022/06/What-is-Figma-A-Design-Crash-Course.jpg?strip=all&lossy=1&resize=1000%2C600&ssl=1");
        Course course3 = this.courseService.save("Figma describe","Creating portfolio", CourseLevel.BEGINNER,"https://uploads-ssl.webflow.com/602623535b0be8085c5f84eb/60271dcd0eafdd287597c556_media_hero_ai.jpg");

        Course course4 = this.courseService.save("Making portfolio","Creating Table", CourseLevel.INTERMEDIATE,"https://i.ytimg.com/vi/g6rQFP9zCAM/maxresdefault.jpg");
        Course course5 = this.courseService.save("Design mobile application","Creating Icons", CourseLevel.INTERMEDIATE,"https://cdn.cssauthor.com/wp-content/uploads/2022/06/What-is-Figma-A-Design-Crash-Course.jpg?strip=all&lossy=1&resize=1000%2C600&ssl=1");
        Course course6 = this.courseService.save("Introducing animation","Creating portfolio", CourseLevel.INTERMEDIATE,"https://uploads-ssl.webflow.com/602623535b0be8085c5f84eb/60271dcd0eafdd287597c556_media_hero_ai.jpg");

        Course course7 = this.courseService.save("Exper level design","Creating Table", CourseLevel.EXPERT,"https://i.ytimg.com/vi/g6rQFP9zCAM/maxresdefault.jpg");
        Course course8 = this.courseService.save("Deploy the app ","Creating Icons", CourseLevel.EXPERT,"https://cdn.cssauthor.com/wp-content/uploads/2022/06/What-is-Figma-A-Design-Crash-Course.jpg?strip=all&lossy=1&resize=1000%2C600&ssl=1");

        User user1 = this.userService.reqister("sreten","strezovskireten@gmail.com","sreten","sreten");


    }
}
