package com.liumapp;

import com.alibaba.fastjson.JSON;
import com.liumapp.sms.sendmsg.request.SmsReportRequest;
import com.liumapp.sms.sendmsg.response.SmsReportResponse;
import com.liumapp.sms.sendmsg.util.ChuangLanSmsUtil;

import java.io.UnsupportedEncodingException;

/**
 * @Description:查询状态报告
 */
public class TestSmsReport {
    public static final String charset = "utf-8";

    public static String account = "account";

    public static String password = "account";


    public static void main(String[] args) throws UnsupportedEncodingException
    {

        String smsReportRequestUrl = "http://smssh1.253.com/msg/pull/report";
        //状态报告拉取条数
        String count = "1";

        SmsReportRequest smsReportRequest = new SmsReportRequest();
        smsReportRequest.setAccount(account)
                .setPassword(password)
                .setCount(count);

        String requestJson = JSON.toJSONString(smsReportRequest);

        System.out.println("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsReportRequestUrl, requestJson);

        System.out.println("response after request result is : " + response);

        SmsReportResponse smsReportRespnse = JSON.parseObject(response, SmsReportResponse.class);

        System.out.println("response  toString is : " + smsReportRespnse.getResult());

    }
}
