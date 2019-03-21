package com.liumapp;

import com.alibaba.fastjson.JSON;
import com.liumapp.sms.sendmsg.request.SmsSendRequest;
import com.liumapp.sms.sendmsg.response.SmsSendResponse;
import com.liumapp.sms.sendmsg.util.ChuangLanSmsUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Description:普通短信发送
 */
public class TestSendSms {
    public static final String charset = "utf-8";

    public static String account = "YourAccount";

    public static String password = "Password";

    public static void main(String[] args) throws UnsupportedEncodingException {
        String smsSingleRequestServerUrl = "https://smssh1.253.com/msg/send/json";

        String testbytes2 = new String(hexstr2bytes("0xF0 0x9F 0x8C 0xB9"),"utf-8");

        String msg1 = "【葫芦娃】您的验证码是124567"; //葫芦娃是签名，必须携带签名

        String msg= URLEncoder.encode(msg1,"utf-8");

        String phone  = "Yourphone";

        String report= "true";

        String extend = "123";

        SmsSendRequest smsSingleRequest = new SmsSendRequest();

        smsSingleRequest.setAccount(account)
                .setPassword(password)
                .setPhone(phone)
                .setMsg(msg)
                .setPhone(phone)
                .setReport(report)
                .setExtend(extend);

        String requestJson = JSON.toJSONString(smsSingleRequest);

        System.out.println("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

        System.out.println("response after request result is :" + response);

        SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

        System.out.println("response  toString is :" + smsSingleResponse);
    }

    //eg. param: 0xF0 0x9F 0x8F 0x80
    public static byte[] hexstr2bytes(String hexstr){
        String[] hexstrs = hexstr.split(" ");
        byte[] b = new byte[hexstrs.length];
        for(int i=0;i<hexstrs.length;i++){
            b[i] = hexStringToByte(hexstrs[i].substring(2))[0];
        }
        System.out.println("b"+b);
        return b;
    }

    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) ("0123456789ABCDEF".indexOf(achar[pos]) << 4 | "0123456789ABCDEF".indexOf(achar[pos + 1]));
        }
        System.out.println("result"+result);
        return result;
    }

}
