package com.example.unit.test.github.test;

public class BasicException extends RuntimeException{
    private int code;

    public BasicException() {
    }

    public BasicException(int code, String message) {
        super(message);
        this.code = code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
