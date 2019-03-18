package com.liumapp;

import com.liumapp.sms.ChuanglanSms;
import com.liumapp.sms.service.SendSmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

/**
 * TODO...
 *
 * @author zwd
 * @since 2019-03-18
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ChuanglanSms.class})
public class TestSms {

    @Autowired
    private SendSmsService sendSmsService;
    @Test
    public void index() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1235646456");
        list.add("1516515615");
        String string = "【葫芦娃】你的验证码为1234";
        Date date = new Date();
        boolean report = true;
        sendSmsService.sendMsg(list, string,date);
    }

}
