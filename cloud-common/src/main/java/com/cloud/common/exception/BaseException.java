package com.cloud.common.exception;

import lombok.Data;

@Data
public class BaseException extends RuntimeException {


    /** @Fields serialVersionUID: */
    private static final long serialVersionUID = 7624072660473224091L;

    private int status = 200;

    BaseException() {
    }

    BaseException(String message, int status) {
        super(message);
        this.status = status;
    }

    BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    
    

}
