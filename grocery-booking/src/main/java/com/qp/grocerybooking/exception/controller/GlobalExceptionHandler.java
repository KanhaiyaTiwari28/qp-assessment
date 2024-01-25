package com.qp.grocerybooking.exception.controller;

import com.qp.grocerybooking.exception.AccessDeniedException;
import com.qp.grocerybooking.exception.InvalidUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<String> handelInvalidUserException(InvalidUserException ex) {
        return new ResponseEntity<>("Invalid user credentials", HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException ex) {
        return new ResponseEntity<>("InValid Role", HttpStatus.UNAUTHORIZED);
    }
}
