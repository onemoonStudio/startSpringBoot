package com.example.exhandler.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{
    private int statusCode;

    public BaseException(int statusCode){
        this(statusCode,null);
    }

    public BaseException(int statusCode,String message){
        super(message);
        this.statusCode = statusCode;
    }



}
