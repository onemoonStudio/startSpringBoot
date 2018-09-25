package com.example.exhandler.exception;

import com.example.exhandler.entity.ErrorModel;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseExceptionHandler{

    @ExceptionHandler(BaseException.class)
    public @ResponseBody ErrorModel handleException(BaseException e) {
        return new ErrorModel(e.getStatusCode(), e.getMessage());
    }


}