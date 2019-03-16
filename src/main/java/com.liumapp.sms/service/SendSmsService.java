package com.liumapp.sms.service;

import com.liumapp.sms.model.Param;

public interface SendSmsService {
    boolean sendMsg(Param param);
}
