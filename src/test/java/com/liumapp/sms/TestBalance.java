package com.liumapp.sms;

import com.alibaba.fastjson.JSONObject;

import com.liumapp.sms.sendmsg.request.smsbalance.SmsBalance;
import com.liumapp.sms.sendmsg.request.smsbalance.SmsBalanceRequest;

import org.junit.Test;

/**
 * Author:Hansn
 * Date: 2019/3/25
 * Time: 下午4:12
 * Description:查询余额
 */
public class TestBalance {

    @Test
    public void testBalance() throws Exception{
        SmsOperator smsOperator = new SmsOperator();
        SmsBalanceRequest smsBalanceRequest = new SmsBalanceRequest();
        SmsBalance smsBalance = new SmsBalance();
        smsBalanceRequest.setPath("/msg/balance/json");
        JSONObject result = smsOperator.doJob(smsBalance,smsBalanceRequest);
        System.out.println(result.toJSONString());
    }
}
