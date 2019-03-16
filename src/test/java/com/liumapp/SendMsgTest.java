package com.liumapp;

import com.liumapp.sms.SmsOperator;
import com.liumapp.sms.model.Param;

import com.liumapp.sms.service.SendSmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SmsOperator.class})
public class SendMsgTest {
    @Autowired
    private SendSmsService sendSmsService;

    @Test
    public void sendmsg() {
        Param param = new Param();
        param.setPhone("17767146460,17316913108");
        param.setMsg("您的验证码是：2530");

        boolean status = sendSmsService.sendMsg(param);
        System.out.println(status);
    }
}
