package com.example.unit.test.github.test;

public class BasicResponse<T> extends CodeMessage {
    private T data;

    public T getData() {
        return this.data;
    }

    public T get() {
        if (!this.isSuccess()) {
            throw new BasicException(this.getCode(), this.getMessage());
        } else {
            return this.data;
        }
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return BasicResponseStatus.SUCCESS.getCode() == this.getCode();
    }

    public BasicResponse(int code, String Message, T data) {
        this.setCode(code);
        this.setMessage(Message);
        this.data = data;
    }

    public BasicResponse() {
    }
}
