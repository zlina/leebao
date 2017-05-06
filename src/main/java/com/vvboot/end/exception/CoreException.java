package com.vvboot.end.exception;

/**
 * Created by LONG on 2017/5/4.
 */
public class CoreException extends RuntimeException {
    private int errorCode = 400000;
    private String error = "操作失败";

    public CoreException(String error) {
        super(error);
        this.error = error;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
