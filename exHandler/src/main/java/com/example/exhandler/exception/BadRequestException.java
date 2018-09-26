package com.example.exhandler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends BaseException{

    public BadRequestException(){
        super(HttpStatus.BAD_REQUEST , "Check Request");
    }

    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

    public static int getCode(){
        return HttpStatus.BAD_REQUEST.value();
    }
}
