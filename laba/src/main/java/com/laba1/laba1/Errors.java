package com.laba1.laba1;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j

public class Errors extends ResponseEntityExceptionHandler {
    //500
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity <?> handleException(final NumberFormatException e){
        log.error("Error - "+ e.getMessage());
        return new ResponseEntity <> (e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //400
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity <?> handleException(final IllegalArgumentException e){
        log.error("Error - "+ e.getMessage());
        return new ResponseEntity <> (e.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
