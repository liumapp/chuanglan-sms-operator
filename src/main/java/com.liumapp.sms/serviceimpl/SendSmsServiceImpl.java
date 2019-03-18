package com.liumapp.sms.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.liumapp.sms.bean.SmsApi;
import com.liumapp.sms.model.Param;
import com.liumapp.sms.service.SendSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.nio.charset.Charset;
@Service
public class SendSmsServiceImpl implements SendSmsService {
    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private SmsApi smsApi;

    /**
     * 单个发送
     * @param param
     * @return
     */
    @Override
    public boolean sendMsg(Param param) {
        param.setAccount(smsApi.getAccount());
        param.setPassword(smsApi.getPassword());
        param.setMsg1(smsApi.getSign()+param.getMsg());

        String s = JSON.toJSONString(param);
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        String post = restTemplate.postForObject(smsApi.getUrl(), s, String.class);
        if (post.contains("23")) {
            return true;
        }
        return false;
    }
}
