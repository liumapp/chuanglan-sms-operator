package com.liumapp.sms.service;


import com.alibaba.fastjson.JSON;
import com.liumapp.sms.bean.SmsApi;
import com.liumapp.sms.model.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SendSmsService {
    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private SmsApi smsApi;

    /**
     * 短信发送
     *  @return
     */
    public String sendMsg(List<String> phoneList, String msg, Date date) {

        Param param = new Param();
        param.setAccount(smsApi.getAccount());
        param.setPassword(smsApi.getPassword());
        param.setMsg1(msg);
        String str = "";
        if (!phoneList.isEmpty()) {
            for (int i=0; i<phoneList.size()-1; i++) {

                str=str + phoneList.get(0) +",";
            }
            str+=phoneList.get(phoneList.size()-1);
        }
        param.setPhone(str);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        String format = simpleDateFormat.format(date);

        param.setSendtime(format);


        String s = JSON.toJSONString(param);
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        String post = restTemplate.postForObject(smsApi.getUrl(), s, String.class);
        return post;
    }
}
