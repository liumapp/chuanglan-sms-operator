package com.liumapp.sms.sendmsg.request;

/**
 * @Description:查询上行短信实体类
 */
public class SmsPullRequest {
    /**
     * 创蓝API账号，必填
     */
    private String account;
    /**
     * 创蓝API密码，必填
     */
    private String password;
    /**
     * 拉取个数（最大100，默认20），选填
     */
    private String count;

    public SmsPullRequest() {

    }
    public SmsPullRequest(String account, String password, String count) {
        super();
        this.account = account;
        this.password = password;
        this.count = count;

    }
    public String getAccount() {
        return account;
    }
    public SmsPullRequest setAccount(String account) {
        this.account = account;
        return this;
    }
    public String getPassword() {
        return password;
    }
    public SmsPullRequest setPassword(String password) {
        this.password = password;
        return this;
    }
    public String getCount() {
        return count;
    }
    public SmsPullRequest setCount(String count) {
        this.count = count;
        return this;
    }
}
