package com.rapisolver.attention.controllers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class RapisolverResponse<T> implements Serializable {

    private static final long serialVersionUID=1L;

    private int code;
    private String message;
    private T data;

    public RapisolverResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public RapisolverResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
