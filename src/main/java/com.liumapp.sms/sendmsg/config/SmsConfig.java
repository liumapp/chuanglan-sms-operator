package com.liumapp.sms.sendmsg.config;

public class SmsConfig {
    private String host;

    public SmsConfig(String host) {
        this.host = host;
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

    @Override
    public String toString() {
        return "SmsConfig{" +
                "host='" + host + '\'' +
                '}';
    }
}
