package com.example.expense_tracker_app.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorsDetails> handleResourceNotFoundException(ResourceNotFoundException
                                                                         resource, WebRequest web){
        ErrorsDetails error=new ErrorsDetails();
        error.setMessage(resource.getMessage());
        error.setErrorCode("Resource_Not_Found");
        error.setDetails(web.getDescription(false));
        error.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ErrorsDetails>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorsDetails> handleGlobalException(Exception resource, WebRequest web){
        ErrorsDetails error=new ErrorsDetails();
        error.setMessage(resource.getMessage());
        error.setErrorCode("INTERNAL_SERVER_ERROR");
        error.setDetails(web.getDescription(false));
        error.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ErrorsDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
