package com.lunchapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lunchapp.exception.DuplicateException;
import com.lunchapp.exception.NoSearchObjectException;
import com.lunchapp.exception.ValidateException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    // 400
    @ExceptionHandler({
            DuplicateException.class,
            ValidateException.class,
            RuntimeException.class
    })
    public ResponseEntity<Object> BadRequestException(final Exception ex) {
        log.warn("error", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    // 404
    @ExceptionHandler({ NoSearchObjectException.class })
    public ResponseEntity<String> notFoundException(final NoSearchObjectException ex) {
        log.warn("error", ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // 500
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(final Exception ex) {
        log.info(ex.getClass().getName());
        log.error("error", ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

