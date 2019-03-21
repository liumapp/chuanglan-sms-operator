package com.liumapp;

import com.alibaba.fastjson.JSON;
import com.liumapp.sms.sendmsg.request.SmsVariableRequest;
import com.liumapp.sms.sendmsg.response.SmsVariableResponse;
import com.liumapp.sms.sendmsg.util.ChuangLanSmsUtil;

import java.io.UnsupportedEncodingException;

/**
 * @Description:变量短信发送
 */
public class TestSmsVariable {
    public static final String charset = "utf-8";

    public static String account = "account";

    public static String password = "password";

    public static void main(String[] args) throws UnsupportedEncodingException {

        String smsVariableRequestUrl = "http://smssh1.253.com/msg/variable/json";
        //设置您要发送的内容：其中“【】”中括号为运营商签名符号，多签名内容前置添加提交
        String msg = "【葫芦娃】尊敬的{$var},您好,您的验证码是{$var},{$var}分钟内有效";
        //参数组
        String params = "132xxxx7141,闫女士,123456,3;";
        //状态报告
        String report= "true";

        SmsVariableRequest smsVariableRequest=new SmsVariableRequest();
        smsVariableRequest.setAccount(account)
                .setPassword(password)
                .setMsg(msg)
                .setParams(params)
                .setReport(report);

        String requestJson = JSON.toJSONString(smsVariableRequest);

        System.out.println("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsVariableRequestUrl, requestJson);

        System.out.println("response after request result is : " + response);

        SmsVariableResponse smsVariableResponse = JSON.parseObject(response, SmsVariableResponse.class);

        System.out.println("response  toString is : " + smsVariableResponse);

    }
}
