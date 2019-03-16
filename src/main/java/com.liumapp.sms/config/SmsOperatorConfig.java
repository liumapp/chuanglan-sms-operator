package com.liumapp.sms.config;

import com.liumapp.sms.bean.SmsApi;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsOperatorConfig {

    @Bean
    @ConfigurationProperties(prefix = "com.liumapp.sms")
    public SmsApi smsApi() {
        SmsApi smsApi = new SmsApi();
        smsApi.setAccount("account");
        smsApi.setPassword("password");
        smsApi.setSign("电子合同");
        smsApi.setUrl("http://smssh1.253.com/msg/send/json");
        return smsApi;
    }
}


