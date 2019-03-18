package com.liumapp.sms.status;

public enum ResponseStatus {
    /**
     *  0:提交成功,101：无此用户,107:错误的手机号
     */
    COMMIT_SUCCESS((byte)0),

    NOT_USER((byte)101),

    ERROR_NUMBER((byte) 107);

    private byte value;

    public byte getValue() {
        return value;
    }

    ResponseStatus(byte value) {
        this.value = value;
    }
}
