package com.liumapp.sms.sendmsg.exception;

/**
 * Author:Hansn
 * Date: 2019/3/25
 * Time: 下午4:12
 * Description:
 */
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
