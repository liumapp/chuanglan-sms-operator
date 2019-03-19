package com.liumapp.sms.bean;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "com.liumapp.sms")
public class SmsApi {

    private String account;

    private String password;

    private String url;

    private String sign;



    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SmsApi(String account, String password, String url, String sign) {
        this.account = account;
        this.password = password;
        this.url = url;
        this.sign = sign;
    }

    public SmsApi(){

    }
}
