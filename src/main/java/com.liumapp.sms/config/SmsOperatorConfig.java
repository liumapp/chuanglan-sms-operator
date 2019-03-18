package com.liumapp.sms.config;

import com.liumapp.sms.bean.SmsApi;
import com.liumapp.sms.service.SendSmsService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConditionalOnClass(SendSmsService.class)
@EnableConfigurationProperties(SmsApi.class)
public class SmsOperatorConfig {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "chuanglan.sms",value = "enabled",havingValue = "true")
    public SendSmsService sendSmsService() {
        return new SendSmsService();
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}


