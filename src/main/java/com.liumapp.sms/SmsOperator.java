package com.liumapp.sms;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.sms.sendmsg.exception.OperateException;
import com.liumapp.sms.sendmsg.job.JobData;
import com.liumapp.sms.sendmsg.job.JobDetail;

public class SmsOperator {
    public JSONObject doJob(JobDetail jobDetail, JobData jobData) throws OperateException{
        return jobDetail.handle(jobData);
    }
}
