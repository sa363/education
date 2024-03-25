package ru.itfb.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BadRequestControllerAdvice {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ProblemDetail> handleBindException(BindException exception) {
        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(HttpStatus.BAD_REQUEST, "%s %s".formatted(exception.getFieldError().getField(), exception.getFieldError().getDefaultMessage()));
        problemDetail.setProperty("errors",
                exception.getAllErrors().stream()
                        .toList());

        return ResponseEntity.badRequest()
                .body(problemDetail);
    }
}
