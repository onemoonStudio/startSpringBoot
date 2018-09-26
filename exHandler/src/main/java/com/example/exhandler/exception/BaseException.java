package com.example.exhandler.exception;

import com.example.exhandler.entity.ErrorModel;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException{
    private int statusCode;
    private HttpStatus status;
    private ErrorModel errorModel;

    public BaseException(HttpStatus status){
        this(status,null);
    }

    public BaseException(HttpStatus status,String message){
        super(message);
        this.status = status;
        this.statusCode = status.value();
        this.errorModel = ErrorModel.builder().code(status.value()).message(message).build();

    }



}
