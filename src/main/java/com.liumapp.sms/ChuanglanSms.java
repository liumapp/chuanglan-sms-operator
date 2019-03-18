package com.liumapp.sms;

import com.liumapp.sms.config.SmsOperatorConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * TODO...
 *
 * @author zwd
 * @since 2019-03-18
 **/

@EnableAutoConfiguration
@Import(SmsOperatorConfig.class)
public class ChuanglanSms {


}
