package com.oburnett127.lms.exceptions;

public class InvalidAccountException extends RuntimeException{
    public InvalidAccountException(String id){
        super("No account found with the given id " + id);
    }
}
