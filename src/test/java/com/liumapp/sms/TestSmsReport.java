package com.liumapp.sms;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.sms.sendmsg.request.smsreport.SmsReport;
import com.liumapp.sms.sendmsg.request.smsreport.SmsReportRequest;
import org.junit.Test;

/**
 * Author:Hansn
 * Date: 2019/3/25
 * Time: 下午4:12
 * Description:查询状态报告
 */
public class TestSmsReport {

    @Test
    public void testSmsReport() throws Exception{
        SmsOperator smsOperator = new SmsOperator();
        SmsReport smsReport = new SmsReport();
        SmsReportRequest smsReportRequest = new SmsReportRequest();
        smsReportRequest.setCount("1")
                .setPath("/msg/pull/report");
        JSONObject result = smsOperator.doJob(smsReport,smsReportRequest);
        System.out.println(result.toJSONString());
    }
}
