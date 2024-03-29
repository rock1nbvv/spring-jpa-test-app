package com.example.app.data;

import lombok.Data;
import lombok.Getter;

/**
 * @author Vlad Baklaiev
 */
@Getter
public class ResponseWrapper<T> {
    private T data;
    private String errorCode;
    private String errorDescription;

    public ResponseWrapper(T data) {
        this.data = data;
    }

    public ResponseWrapper(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }
}
