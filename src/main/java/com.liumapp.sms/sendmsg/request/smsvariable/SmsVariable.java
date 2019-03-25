package com.liumapp.sms.sendmsg.request.smsvariable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liumapp.qtools.security.encrypt.Sha256Tool;
import com.liumapp.sms.sendmsg.exception.OperateException;
import com.liumapp.sms.sendmsg.job.JobDetail;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Author:Hansn
 * Date: 2019/3/25
 * Time: 下午4:12
 * Description:
 */
public class SmsVariable extends JobDetail<SmsVariableRequest> {
    public SmsVariable() throws IOException {
    }

    public JSONObject handle(SmsVariableRequest data) throws OperateException {
        if (!data.checkParams()) {
            jobResult.put("msg", "check params failed!");
            return jobResult;
        }
        headers.put("Content-Type", "application/text");
        headers.put("charset","utf_8");
        params.put("account", smsConfig.getAccount());
        params.put("password", smsConfig.getPassword());
        params.put("msg",data.getMsg());
        params.put("params",data.getParams());
        params.put("sendtime",data.getSendtime());
        params.put("report",data.getReport());
        params.put("extend",data.getExtend());
        params.put("uid",data.getUid());
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
