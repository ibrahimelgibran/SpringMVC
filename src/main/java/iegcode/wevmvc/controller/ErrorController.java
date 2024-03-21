package iegcode.wevmvc.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidationException (MethodArgumentNotValidException exception){
        return ResponseEntity.badRequest().body("Validation Error : " + exception.getMessage());
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> constraintViolationException (ConstraintViolationException exception){
        return ResponseEntity.badRequest().body("Validation Error : " + exception.getMessage());
    }
}
