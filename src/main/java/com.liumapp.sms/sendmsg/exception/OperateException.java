package com.liumapp.sms.sendmsg.exception;

public class OperateException extends Exception {
    public OperateException(String message) {
        super(message);
    }

    public OperateException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperateException(Throwable cause) {
        super(cause);
    }
}
