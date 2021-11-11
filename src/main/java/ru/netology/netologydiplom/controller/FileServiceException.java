package ru.netology.netologydiplom.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.netologydiplom.exceptions.FileNotFoundException;
import ru.netology.netologydiplom.payload.response.ErrorMessageResponse;

@RestControllerAdvice
public class FileServiceException {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadCredentialsException.class)
    public ErrorMessageResponse badCredentialsExceptionHandler(BadCredentialsException e) {
        return ErrorMessageResponse.builder()
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(FileNotFoundException.class)
    public ErrorMessageResponse fileServiceFileException(FileNotFoundException e) {
        return ErrorMessageResponse.builder()
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorMessageResponse exception(Exception e) {
        return ErrorMessageResponse.builder()
                .message(e.getMessage())
                .build();
    }

}
