package com.liumapp.sms;

import com.liumapp.sms.bean.SmsApi;
//import com.liumapp.sms.config.SmsOperatorConfig;
import com.liumapp.sms.config.SmsOperatorConfig;
import com.liumapp.sms.request.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Import({SmsOperatorConfig.class})
public class SmsOperator {
    @Bean
    public SendSms sendSms(){
        return new SendSms();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
