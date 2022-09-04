package com.example.domasna5_dnick.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserIdNotFoundException extends RuntimeException{
    public UserIdNotFoundException(Long userId) {
        super(String.format("User with id %d was not found!",userId));
    }
}
