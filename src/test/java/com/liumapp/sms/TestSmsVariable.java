package com.liumapp.sms;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.sms.sendmsg.request.smsvariable.SmsVariable;
import com.liumapp.sms.sendmsg.request.smsvariable.SmsVariableRequest;
import org.junit.Test;

/**
 * @Description:变量短信发送
 */
public class TestSmsVariable {

    @Test
    public void testVariable() throws Exception{
        SmsOperator smsOperator = new SmsOperator();
        SmsVariable smsVariable = new SmsVariable();
        SmsVariableRequest smsVariableRequest = new SmsVariableRequest();
        smsVariableRequest.setAccount("N2802947")
                .setPassword("S5nemwZjq")
                .setMsg("【葫芦娃】尊敬的{$var},您好,您的验证码是{$var},{$var}分钟内有效")
                .setParams("13262107141,闫女士,123456,3;")
                .setReport("true")
                .setPath("/msg/variable/json");
        JSONObject result = smsOperator.doJob(smsVariable,smsVariableRequest);
        System.out.println(result.toJSONString());
    }
}
