package com.paystack.demo.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class PaymentException {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {

        List<String> errors = new ArrayList<>();

        methodArgumentNotValidException.getFieldErrors().forEach((data) -> {
            String fieldName = data.getField();
            String errMsg = data.getDefaultMessage();
            errors.add("field : "+ fieldName+" has Error: "+errMsg);
            log.error("field {} has Error: {}",fieldName,errMsg);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
