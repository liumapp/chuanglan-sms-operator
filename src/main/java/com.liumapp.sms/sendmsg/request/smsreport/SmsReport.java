package com.liumapp.sms.sendmsg.request.smsreport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liumapp.qtools.security.encrypt.Sha256Tool;
import com.liumapp.sms.sendmsg.exception.OperateException;
import com.liumapp.sms.sendmsg.job.JobDetail;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SmsReport extends JobDetail<SmsReportRequest> {
    public SmsReport() throws IOException {
    }

    public JSONObject handle(SmsReportRequest data) throws OperateException {
        if(!data.checkParams()){
            jobResult.put("msg","check params failed");
            return jobResult;
        }
        headers.put("Content-Type", "application/json");
        params.put("account",data.getAccount());
        params.put("password",data.getPassword());
        params.put("count",data.getCount());
        String jsonParams = JSON.toJSONString(params);
        headers.put("hash", Sha256Tool.toSha256String(jsonParams));
        HttpResponse response = null;

        try {
            response = httpTool.doPost(
                    smsConfig.getHost(),
                    data.getPath(),
                    "post",
                    headers,
                    querys,jsonParams
            );
        } catch (Exception e) {
            throw  new OperateException("send request failed");
        }
        String res = null;
        try {
            res = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new OperateException("convert response to string failed");
        }
        return JSON.parseObject(res);
    }
}
