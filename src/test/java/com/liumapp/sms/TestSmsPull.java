package com.liumapp.sms;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.sms.sendmsg.request.smspull.SmsPull;
import com.liumapp.sms.sendmsg.request.smspull.SmsPullRequest;
import org.junit.Test;


/**
 * @Description:查询上行短信
 */
public class TestSmsPull {

    @Test
    public void tsetSmsPull() throws Exception{
        SmsOperator smsOperator = new SmsOperator();
        SmsPullRequest smsPullRequest = new SmsPullRequest();
        SmsPull smsPull = new SmsPull();
        smsPullRequest.setAccount("N2802947")
                .setPassword("S5nemwZjq")
                .setCount("1")
                .setPath("/msg/pull/mo");
        JSONObject result = smsOperator.doJob(smsPull,smsPullRequest);
        System.out.println(result.toJSONString());
    }
}
