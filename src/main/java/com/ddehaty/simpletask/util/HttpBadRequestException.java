package com.ddehaty.simpletask.util;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class HttpBadRequestException extends RuntimeException {
    private String message;

    public HttpBadRequestException(String message) {
        this.message = message;
    }
}
