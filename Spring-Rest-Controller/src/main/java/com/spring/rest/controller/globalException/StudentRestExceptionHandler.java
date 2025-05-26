package com.spring.rest.controller.globalException;

import com.spring.rest.controller.controller.StudentNotFoundException;
import com.spring.rest.controller.model.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Varun Saxena
 * @version 1.0
 * @since 2022-01-26
 * Using AOP Concept to handle Exceptions
 */

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        error.setMessage(exc.getMessage());
        error.setTimestamp(String.valueOf(System.currentTimeMillis()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        error.setMessage(exc.getMessage());
        error.setTimestamp(String.valueOf(System.currentTimeMillis()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
