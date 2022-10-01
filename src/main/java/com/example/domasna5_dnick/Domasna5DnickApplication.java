package com.example.domasna5_dnick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class Domasna5DnickApplication {
    @Controller
    @SpringBootApplication
    public class DemoApplication {

        @RequestMapping("/")
        @ResponseBody
        String home() {
            return "Hello World!";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Domasna5DnickApplication.class, args);
    }


}
