package com.vn.sanght.challenge.web.controller;

import com.vn.sanght.challenge.common.constant.ErrorCode;
import com.vn.sanght.challenge.common.exception.BaseException;
import com.vn.sanght.challenge.web.vmodel.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleAllException(Exception ex, WebRequest request) {
        return new ErrorMessage(ErrorCode.INTERNAL_SERVER_ERROR,
                ex.getLocalizedMessage());
    }

    @ExceptionHandler({BaseException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage generalException(BaseException ex, WebRequest request) {
        return new ErrorMessage(ex.getErrorCode(), ex.getLocalizedMessage());
    }
}
