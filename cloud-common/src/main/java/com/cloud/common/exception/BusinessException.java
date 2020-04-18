package com.cloud.common.exception;

public class BusinessException extends BaseException{

    private static final long serialVersionUID = -810553123459130270L;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, int status) {
        super(message, status);
    }
}
