package com.liumapp.sms.sendmsg.request.smsvariable;

import com.liumapp.qtools.str.basic.StrTool;
import com.liumapp.sms.sendmsg.job.JobData;

/**
 * @Description:变量短信发送实体类
 */
public class SmsVariableRequest extends JobData {
    /**
     * 创蓝API账号，必填
     */
    private String account;
    /**
     * 创蓝API密码，必填
     */
    private String password;
    /**
     * 短信内容。长度不能超过536个字符，必填
     */
    private String msg;
    /**
     * 手机号码和变量参数，多组参数使用英文分号;区分，必填
     */
    private String params;

    /**
     * 定时发送短信时间。格式为yyyyMMddHHmm，值小于或等于当前时间则立即发送，默认立即发送，选填
     */
    private String sendtime;
    /**
     * 是否需要状态报告（默认false），选填
     */
    private String report;
    /**
     * 下发短信号码扩展码，纯数字，建议1-3位，选填
     */
    private String extend;
    /**
     * 该条短信在您业务系统内的ID，如订单号或者短信发送记录流水号，选填
     */
    private String uid;
    /**
     * https
     */
    private String path;

    public SmsVariableRequest() {

    }

    public SmsVariableRequest(String account, String password, String msg, String params, String sendtime, String report, String extend, String uid, String path) {
        this.account = account;
        this.password = password;
        this.msg = msg;
        this.params = params;
        this.sendtime = sendtime;
        this.report = report;
        this.extend = extend;
        this.uid = uid;
        this.path = path;
    }

    public String getAccount() {
        return account;
    }
    public SmsVariableRequest setAccount(String account) {
        this.account = account;
        return this;
    }
    public String getPassword() {
        return password;
    }
    public SmsVariableRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getMsg() {
        return msg;
    }
    public SmsVariableRequest setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getSendtime() {
        return sendtime;
    }
    public SmsVariableRequest setSendtime(String sendtime) {
        this.sendtime = sendtime;
        return this;
    }

    public String getReport() {
        return report;
    }
    public SmsVariableRequest setReport(String report) {
        this.report = report;
        return this;
    }

    public String getExtend() {
        return extend;
    }
    public SmsVariableRequest setExtend(String extend) {
        this.extend = extend;
        return this;
    }
    public String getUid() {
        return uid;
    }
    public SmsVariableRequest setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getParams() {
        return params;
    }
    public SmsVariableRequest setParams(String params) {
        this.params = params;
        return this;
    }

    public String getPath() {
        return path;
    }

    public SmsVariableRequest setPath(String path) {
        this.path = path;
        return this;
    }
    public boolean checkParams () {
        if (StrTool.isSpace(this.path))
            this.path = "/msg/variable/json";
        return true;
    }
}
