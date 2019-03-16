package com.liumapp.sms.request;

import com.alibaba.fastjson.JSON;
import com.liumapp.sms.bean.SmsApi;
import com.liumapp.sms.model.Param;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Component
public class SendSms {

//    @Autowired
//    private RestTemplate restTemplate;
//    @Resource
//    private SmsApi smsApi;
//
//    public boolean sendsms(@RequestBody Param param){
////        List<NameValuePair> nvps = new ArrayList<>();
////        nvps.add(new BasicNameValuePair("account", smsApi.getAccount()));
////        nvps.add(new BasicNameValuePair("password", smsApi.getPassword()));
////        nvps.add(new BasicNameValuePair("phone", param.getPhone()));
//////        nvps.add(new BasicNameValuePair("report", param.getReport()));
////        nvps.add(new BasicNameValuePair("msg", param.getMsg()));
////        nvps.add(new BasicNameValuePair("sendtime", param.getSendtime()));
////        nvps.add(new BasicNameValuePair("uid", param.getUid()));
////        nvps.add(new BasicNameValuePair("extend", param.getExtend()));
////        String post = HttpPost.httpPost(smsApi.getUrl(), nvps);  //post请求
//
//        param.setAccount(smsApi.getAccount());
//        param.setPassword(smsApi.getPassword());
//
//        String s = JSON.toJSONString(param);
//        restTemplate.getMessageConverters()
//                .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
//        String post = restTemplate.postForObject(smsApi.getUrl(), s, String.class);
//        if (post.contains("23")) {
//            return true;
//        }
//        return false;
//    }
}
