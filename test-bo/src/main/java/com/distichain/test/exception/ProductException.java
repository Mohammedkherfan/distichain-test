package com.distichain.test.exception;

import com.distichain.test.common.ResponseCode;
import lombok.Getter;

@Getter
public class ProductException extends RuntimeException {

    private ResponseCode responseCode;

    public ProductException(ResponseCode responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
    }

    public ProductException(ResponseCode responseCode, String message, Throwable cause) {
        super(message, cause);
        this.responseCode = responseCode;
    }

    public ProductException(ResponseCode responseCode, Throwable cause) {
        super(cause);
        this.responseCode = responseCode;
    }

    public ProductException(ResponseCode responseCode, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.responseCode = responseCode;
    }
}
