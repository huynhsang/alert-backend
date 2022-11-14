package com.vn.sanght.challenge.common.exception;

public class BaseException extends RuntimeException {
    private int errorCode;

    public BaseException(String msg, int errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
