package com.liumapp.sms.sendmsg.config;

/**
 * Author:Hansn
 * Date: 2019/3/25
 * Time: 下午4:12
 * Description:
 */
public class SmsConfig {
    private String host;

    private String account;

    private String password;

    public SmsConfig(String host, String account, String password) {
        this.host = host;
        this.account = account;
        this.password = password;
    }

    public SmsConfig(){

    }

    public String getHost() {
        return host;
    }

    public SmsConfig setHost(String host) {
        this.host = host;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public SmsConfig setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SmsConfig setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "SmsConfig{" +
                "host='" + host + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
