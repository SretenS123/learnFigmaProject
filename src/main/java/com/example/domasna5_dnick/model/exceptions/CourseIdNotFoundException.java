package com.example.domasna5_dnick.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CourseIdNotFoundException  extends RuntimeException{
    public CourseIdNotFoundException(Long courseId) {
        super(String.format("Course with id %d was not found!",courseId));
    }
}
