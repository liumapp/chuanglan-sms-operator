package com.liumapp;

import com.alibaba.fastjson.JSON;
import com.liumapp.sms.sendmsg.request.SmsBalanceRequest;
import com.liumapp.sms.sendmsg.response.SmsBalanceResponse;
import com.liumapp.sms.sendmsg.util.ChuangLanSmsUtil;

import java.io.UnsupportedEncodingException;

/**
 * @Description:查询余额
 */
public class TestBalance {

    public static final String charset = "utf-8";
    public static String account = "account";
    public static String password = "password";


    public static void main(String[] args) throws UnsupportedEncodingException {

        String smsBalanceRequestUrl = "http://smssh1.253.com/msg/balance/json";

        SmsBalanceRequest smsBalanceRequest=new SmsBalanceRequest();
        smsBalanceRequest.setAccount(account)
                .setPassword(password);

        String requestJson = JSON.toJSONString(smsBalanceRequest);

        System.out.println("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsBalanceRequestUrl, requestJson);

        System.out.println("response after request result is : " + response);

        SmsBalanceResponse smsVarableResponse = JSON.parseObject(response, SmsBalanceResponse.class);

        System.out.println("response  toString is : " + smsVarableResponse);

    }
}
