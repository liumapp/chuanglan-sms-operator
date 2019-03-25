package com.liumapp.sms.sendmsg.job;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.qtools.http.HttpTool;
import com.liumapp.qtools.property.core.ConfigurationNode;
import com.liumapp.qtools.property.core.loader.ConfigurationLoader;
import com.liumapp.qtools.property.yaml.YAMLConfigurationLoader;
import com.liumapp.sms.sendmsg.config.SmsConfig;
import com.liumapp.sms.sendmsg.exception.OperateException;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public abstract class JobDetail<T extends JobData> {
    protected JSONObject jobResult;

    protected SmsConfig smsConfig;

    protected HttpTool httpTool;

    public Map<String, String> headers = new HashMap<String, String>();

    public Map<String, String> querys = new HashMap<String, String>();

    public Map<String, Object> params = new HashMap<String, Object>();

    public String body;

    public JobDetail() throws IOException {
        this.jobResult = new JSONObject();
        this.smsConfig = this.buildsmsConfig();
        this.httpTool = new HttpTool();
    }

    public abstract JSONObject handle(T data) throws OperateException;

    private SmsConfig buildsmsConfig () throws IOException {
        URL url = getClass().getResource("/sms-config.yml");
        ConfigurationLoader loader = YAMLConfigurationLoader.builder()
                .setURL(url).build();
        ConfigurationNode node = loader.load();
        SmsConfig smsConfig = new SmsConfig(
                node.getNode("com", "liumapp", "sms", "host").getValue().toString()
        );
        return smsConfig;
    }
}
