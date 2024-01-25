package com.qp.grocerybooking.exception;

public class InvalidUserException extends RuntimeException {

    public InvalidUserException(String msg){
        super(msg);
    }
}
