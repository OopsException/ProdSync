package com.ProdSync.ProdSync.execption;

import lombok.Getter;

@Getter
public class RestException extends RuntimeException{

    private final String status;

    private RestException(String status, String message) {
        super(message);
        this.status = status;
    }

    public static RestException INVALID(String message) {
        return new RestException("INVALID", message);
    }

    public static RestException FORBIDDEN(String message) {
        return new RestException("FORBIDDEN", message);
    }
}
