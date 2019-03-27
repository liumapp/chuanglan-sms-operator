package com.liumapp.sms;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.sms.sendmsg.exception.OperateException;
import com.liumapp.sms.sendmsg.job.JobData;
import com.liumapp.sms.sendmsg.job.JobDetail;

/**
 * file SmsOperator.java
 * Author:Hansn
 * Date: 2019/3/25
 * Time: 下午4:12
 */
public class SmsOperator {
    public JSONObject doJob(JobDetail jobDetail, JobData jobData) throws OperateException{
        return jobDetail.handle(jobData);
    }
}
