package com.liumapp;

import com.alibaba.fastjson.JSON;
import com.liumapp.sms.sendmsg.request.SmsPullRequest;
import com.liumapp.sms.sendmsg.response.SmsPullResponse;
import com.liumapp.sms.sendmsg.util.ChuangLanSmsUtil;

import java.io.UnsupportedEncodingException;

/**
 * @Description:查询上行短信
 */
public class TestSmsPull {
    public static final String charset = "utf-8";

    public static String account = "account";

    public static String password = "password";

    public static void main(String[] args) throws UnsupportedEncodingException {

        //拉取上行的URlL 请登录zz.253.com 获取完整的URL接口信息
        String smsPullRequestUrl = "https://smssh1.253.com/msg/pull/mo";
        //上行拉取条数
        String count = "1";

        SmsPullRequest smsPullRequest = new SmsPullRequest();

        smsPullRequest.setAccount(account)
                .setPassword(password)
                .setCount(count);

        String requestJson = JSON.toJSONString(smsPullRequest);

        System.out.println("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsPullRequestUrl, requestJson);

        System.out.println("response after request result is : " + response);

        SmsPullResponse smsPullResponse = JSON.parseObject(response, SmsPullResponse.class);

        System.out.println("response  toString is : " + smsPullResponse);
    }
}
