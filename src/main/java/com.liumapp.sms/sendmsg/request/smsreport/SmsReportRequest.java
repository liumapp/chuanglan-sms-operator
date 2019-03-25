package com.liumapp.sms.sendmsg.request.smsreport;

import com.liumapp.qtools.str.basic.StrTool;
import com.liumapp.sms.sendmsg.job.JobData;

/**
 * @Description:查询状态报告实体类
 */
public class SmsReportRequest extends JobData {
    /**
     * 创蓝API账号，必填
     */
    private String account;
    /**
     * 创蓝API密码，必填
     */
    private String password;
    /**
     * 拉取个数（最大100，默认20），选填
     */
    private String count;

    /**
     * https
     */
    private String path;

    public SmsReportRequest() {

    }

    public SmsReportRequest(String account, String password, String count, String path) {
        this.account = account;
        this.password = password;
        this.count = count;
        this.path = path;
    }

    public String getAccount() {
        return account;
    }
    public SmsReportRequest setAccount(String account) {
        this.account = account;
        return this;
    }
    public String getPassword() {
        return password;
    }
    public SmsReportRequest setPassword(String password) {
        this.password = password;
        return this;
    }
    public String getCount() {
        return count;
    }
    public SmsReportRequest setCount(String count) {
        this.count = count;
        return this;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean checkParams() {
        if (StrTool.isSpace(this.path))
            this.path = "/msg/pull/report";
        return true;
    }
}
