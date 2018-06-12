package com.sailei.mvpdemo.api;


public class BaseResponse<T> {
    private int code;
    private String message;
    private T result;
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return message;
    }

    public void setStatusMsg(String statusMsg) {
        this.message = statusMsg;
    }

    public int getStatus() {

        return code;
    }

    public void setStatusCode(int statusCode) {
        this.code = statusCode;
    }

    public T getData() {
        return result;
    }

    public void setData(T data) {
        this.result = data;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                ", success=" + success +
                '}';
    }
}
