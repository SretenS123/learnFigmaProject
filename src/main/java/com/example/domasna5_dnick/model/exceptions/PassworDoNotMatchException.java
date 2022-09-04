package com.example.domasna5_dnick.model.exceptions;

public class PassworDoNotMatchException extends RuntimeException{

    public PassworDoNotMatchException()
    {
        super("Passwords dont match eachother!");
    }
}
