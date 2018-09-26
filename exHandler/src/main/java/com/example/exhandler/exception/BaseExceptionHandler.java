package com.example.exhandler.exception;

import com.example.exhandler.entity.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseExceptionHandler{

    @ExceptionHandler(BaseException.class)
    public @ResponseBody ErrorModel handleException(BaseException e) {
        return new ErrorModel(e.getStatusCode(), e.getMessage());
    }

//    @ExceptionHandler(ConflictException.class)
//    public @ResponseBody ErrorModel handleConfilictException(BaseException e ){
//        System.out.println("hear1");
//        return new ErrorModel(e.getStatusCode(),e.getMessage());
//    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorModel> handleConfilictException(BaseException e){
        return new ResponseEntity<>(e.getErrorModel(),e.getStatus());
    }



}