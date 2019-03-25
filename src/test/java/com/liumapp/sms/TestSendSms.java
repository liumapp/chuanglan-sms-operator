package com.liumapp.sms;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.sms.sendmsg.request.smssend.SmsSend;
import com.liumapp.sms.sendmsg.request.smssend.SmsSendRequest;
import org.junit.Test;

/**
 * @Description:普通短信发送
 */
public class TestSendSms {

    @Test
    public void testSendSms() throws Exception{
        String msg = "【葫芦娃】您的验证码是124567"; //葫芦娃是签名，必须携带签名

        SmsOperator smsOperator = new SmsOperator();
        SmsSend smsSend = new SmsSend();
        SmsSendRequest smsSendRequest = new SmsSendRequest();
        smsSendRequest.setAccount("N2802947")
                .setPassword("S5nemwZjq")
                .setMsg(msg)
                .setPath("/msg/send/json")
                .setPhone("17767146460")
                .setPath("/msg/send/json");
        JSONObject result = smsOperator.doJob(smsSend,smsSendRequest);
        System.out.println(result.toJSONString());
    }
}
