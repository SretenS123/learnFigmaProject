package com.example.domasna5_dnick.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException{
    public InvalidUserCredentialsException()
    {
        super("Invalid User!");
    }
}
