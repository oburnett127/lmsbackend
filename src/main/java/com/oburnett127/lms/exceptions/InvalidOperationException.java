package com.oburnett127.lms.exceptions;

public class InvalidOperationException extends RuntimeException{
    public InvalidOperationException(){
        super("The operation you are trying to perform is invalid.");
    }
}

