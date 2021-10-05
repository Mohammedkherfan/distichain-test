package com.distichain.test.handler;

import com.distichain.test.common.ResponseCode;
import com.distichain.test.exception.ProductException;
import com.distichain.test.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> exception(Exception exception) {
        log.error("Error during request.", exception);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .responseCode(ResponseCode.TECHNICAL_ERROR.getCode())
                .responseMessage(ResponseCode.TECHNICAL_ERROR.getDescription() + ",Please check with admin")
                .responseTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("error in the request MethodArgumentNotValidException ", e);
        FieldError fieldError = e.getBindingResult().getFieldError();
        String field = fieldError.getField();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .responseCode(ResponseCode.TECHNICAL_ERROR.getCode())
                .responseMessage(("Error in " + field + " : " + fieldError.getDefaultMessage()))
                .responseTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ProductException.class)
    public ResponseEntity<ErrorResponse> productException(ProductException exception) {
        log.error("Error during request.", exception);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .responseCode(exception.getResponseCode().getCode())
                .responseMessage(exception.getMessage())
                .responseTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
