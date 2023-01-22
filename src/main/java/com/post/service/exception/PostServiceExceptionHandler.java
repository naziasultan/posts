package com.post.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class PostServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ServiceNotAvailableException.class})
    public ResponseEntity<ErrorResponse> handleProductServiceNotAvailableException(ServiceNotAvailableException exception, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(
                HttpStatus.SERVICE_UNAVAILABLE,
                exception.getMessage(),
                request.getDescription(false),
                exception),
                HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(NotFoundException exception, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                request.getDescription(false)),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleGenericException(NullPointerException exception, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                request.getDescription(false)),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception exception, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                request.getDescription(false)),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}