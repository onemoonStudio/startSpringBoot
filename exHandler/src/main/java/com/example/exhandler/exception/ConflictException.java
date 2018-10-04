package com.example.exhandler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends BaseException{
    public ConflictException(){
        super(HttpStatus.CONFLICT.value() , "Conflict");
    }

    public ConflictException(String message) {
        super(HttpStatus.CONFLICT.value(), message);
    }
}
