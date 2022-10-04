package com.book.exceptions;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(String token){
        super("Invalid Token !! " + token);
    }
}