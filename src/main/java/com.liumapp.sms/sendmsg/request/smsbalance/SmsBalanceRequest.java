package com.liumapp.sms.sendmsg.request.smsbalance;

import com.liumapp.qtools.str.basic.StrTool;
import com.liumapp.sms.sendmsg.job.JobData;
/**
 * Author:Hansn
 * Date: 2019/3/25
 * Time: 下午4:12
 * Description:查询账号余额实体类
 */
public class SmsBalanceRequest extends JobData {
    /**
     * 创蓝API账号，必填
     */
    private String account;
    /**
     * 创蓝API密码，必填
     */
    private String password;
    /**
     * https地址
     */
    private String path;

    public SmsBalanceRequest() {

    }

    public SmsBalanceRequest(String account, String password, String path) {
        this.account = account;
        this.password = password;
        this.path = path;
    }

    public String getAccount() {
        return account;
    }

    public SmsBalanceRequest setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SmsBalanceRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPath() {
        return path;
    }

    public SmsBalanceRequest setPath(String path) {
        this.path = path;
        return this;
    }

    public boolean checkParams() {
        if (StrTool.isSpace(this.path))
            this.path = "/msg/balance/json";
        return true;
    }
}
