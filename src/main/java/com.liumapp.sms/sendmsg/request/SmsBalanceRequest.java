package com.liumapp.sms.sendmsg.request;

/**
 * @Description:查询账号余额实体类
 */
public class SmsBalanceRequest {
    /**
     * 创蓝API账号，必填
     */
    private String account;
    /**
     * 创蓝API密码，必填
     */
    private String password;

    public SmsBalanceRequest() {

    }
    public SmsBalanceRequest(String account, String password) {
        super();
        this.account = account;
        this.password = password;

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

}
